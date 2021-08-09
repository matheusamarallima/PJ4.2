//package com.wipro.rp.skillmng.domain;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Role {
//
//	@Id
//	private Long id;
//	private String name;
//	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//	private List<Skill> skills;
//
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public List<Skill> getSkills() {
//		return skills;
//	}
//	public void setSkills(List<Skill> skills) {
//		this.skills = skills;
//	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Role)) {
//			return false;
//		}
//
//		Role other = (Role) obj;
//
//		if (id == null) {
//			if (other.id != null) {
//				return false;
//			}
//		} else if (!id.equals(other.id)) {
//			return false;
//		}
//
//		return true;
//	}
//}
