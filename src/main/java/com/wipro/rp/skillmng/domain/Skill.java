//package com.wipro.rp.skillmng.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Skill {
//
//	@Id
//	private String id;
//	private String name;
//	@ManyToOne
//	private Band band;
//	@ManyToOne
//	private Role role;
//
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Band getBand() {
//		return band;
//	}
//	public void setBand(Band band) {
//		this.band = band;
//	}
//	public Role getRole() {//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
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
//		if (!(obj instanceof Skill)) {
//			return false;
//		}
//
//		Skill other = (Skill) obj;
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
