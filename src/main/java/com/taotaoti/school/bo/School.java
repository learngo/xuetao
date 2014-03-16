package com.taotaoti.school.bo;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "school", keyColumn = SchoolColumns.schoolId)
public class School extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=SchoolColumns.name)
	private String name ;
	@Column(value=SchoolColumns.email)
	private String email;
	@Column(value=SchoolColumns.statu)
	private Integer statu;
	
	
	

	public School() {
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Integer getStatu() {
		return statu;
	}




	public void setStatu(Integer statu) {
		this.statu = statu;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public School(String name, String email, Integer statu) {
		super();
		this.name = name;
		this.email = email;
		this.statu = statu;
	}




	
}
