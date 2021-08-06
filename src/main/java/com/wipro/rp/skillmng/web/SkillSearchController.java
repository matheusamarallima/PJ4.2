package com.wipro.rp.skillmng.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.rp.skillmng.data.BandRepository;
import com.wipro.rp.skillmng.data.RoleRepository;
import com.wipro.rp.skillmng.data.SkillRepository;
import com.wipro.rp.skillmng.domain.Band;
import com.wipro.rp.skillmng.domain.Role;

@Controller
public class SkillSearchController {

	private RoleRepository roleRepo;
	private BandRepository bandRepo;
	private SkillRepository skillRepo;
	
	public SkillSearchController(
			RoleRepository roleRepo,
			BandRepository bandRepo,
			SkillRepository skillRepo) {
		this.roleRepo = roleRepo;
		this.bandRepo = bandRepo;
		this.skillRepo = skillRepo; 
	}
	
	@RequestMapping(method={RequestMethod.GET,RequestMethod.POST}, value= "/skillsearch")
	public String skillSearch(
			Model model,
			@RequestParam(required = false) Band band,
			@RequestParam(required = false) Role role) {
		Iterable<Role> roles = roleRepo.findAll();
		Iterable<Band> bands = bandRepo.findAll();
		model.addAttribute("roleList", roles);
		model.addAttribute("bandList", bands);
		if(band == null && role == null) {
			role = roles.iterator().next();
			band = bands.iterator().next();
		}
		model.addAttribute("roleValue", role);
		model.addAttribute("bandValue", band);
		model.addAttribute("skillList", this.skillRepo.findAllByRoleAndBand(role, band));
		return "skillsearch";
	}
}