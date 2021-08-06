package com.wipro.rp.skillmng.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.rp.skillmng.domain.User;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(
			Model model,
			@RequestParam(required=false) String success) {
		if(success != null) {
			String message = null;
			if(success.equals("1")) {
				message = "User successfully registered. Login to continue";
			} else if(success.equals("2")) {
				message = "Password successfully changed";
			}
			model.addAttribute("successMessage", message);
		}
		return "login";
	}

	@GetMapping("/loginSuccess")
	public String relativeHome(@AuthenticationPrincipal User user) {
		if(user != null) {
			String roles = user.getAuthorities().toString();
			if(roles.contains("ROLE_EMPLOYEE")) {
				return "redirect:/employeesearch";
			} else if(roles.contains("ROLE_ADMIN")){
				return "redirect:/home";
			}
		}
		return "redirect:/login";
	}
}