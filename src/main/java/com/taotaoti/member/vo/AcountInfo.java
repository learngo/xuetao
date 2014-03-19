package com.taotaoti.member.vo;

import com.taotaoti.member.bo.Member;

public class AcountInfo extends Member {
	private static final long serialVersionUID = 4089458387116208127L;
	private String[] authArr = new String[]{};
	private String[] roleArr = new String[]{};
	
	public AcountInfo() {
     super();
	}
	public AcountInfo(Member member){
		this.id=member.getId();
		this.setId(member.getId());
		this.setCreateTime(member.getCreateTime());
		this.setEmail(member.getEmail());
		this.setName(member.getName());
		this.setPassword(member.getPassword());
		this.setRoleid(member.getRoleid());
		this.setUpdateTime(member.getUpdateTime());
		this.setSchoolId(member.getSchoolId());
	}
	public String[] getAuthArr() {
		return authArr;
	}
	public void setAuthArr(String[] authArr) {
		this.authArr = authArr;
	}
	public String[] getRoleArr() {
		return roleArr;
	}
	public void setRoleArr(String[] roleArr) {
		this.roleArr = roleArr;
	}

}
