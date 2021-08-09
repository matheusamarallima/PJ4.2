//package com.wipro.rp.skillmng.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
//@Entity
//public class Band {
//
//	@Id
//	private Long id;
//	private String description;
//
//
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
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
//		if (!(obj instanceof Band)) {
//			return false;
//		}
//		Band other = (Band) obj;
//		if (id == null) {
//			if (other.id != null) {
//				return false;
//			}
//		} else if (!id.equals(other.id)) {
//			return false;
//		}
//		return true;
//	}
//}