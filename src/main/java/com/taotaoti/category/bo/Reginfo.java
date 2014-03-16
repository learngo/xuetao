package com.taotaoti.category.bo;

import java.io.Serializable;

/**
 * 地域字典表
 * 
 * @version 2013-5-3 下午4:49:41
 */
public class Reginfo implements Serializable, Comparable<Reginfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6686559913921460686L;
	/**
	 * 一级地域id
	 */
	private int firstRegid;
	/**
	 * 二级地域id
	 */
	private int secondRegid;
	/**
	 * 省市关系，网吧/电信等
	 */
	private int regType;

	/**
	 * 地域名
	 */
	private String regName;

	/**
	 * @return the firstRegid
	 */
	public int getFirstRegid() {
		return firstRegid;
	}

	/**
	 * @param firstRegid
	 *            the firstRegid to set
	 */
	public void setFirstRegid(int firstRegid) {
		this.firstRegid = firstRegid;
	}

	/**
	 * @return the secondRegid
	 */
	public int getSecondRegid() {
		return secondRegid;
	}

	/**
	 * @param secondRegid
	 *            the secondRegid to set
	 */
	public void setSecondRegid(int secondRegid) {
		this.secondRegid = secondRegid;
	}

	/**
	 * @return the regType
	 */
	public int getRegType() {
		return regType;
	}

	/**
	 * @param regType
	 *            the regType to set
	 */
	public void setRegType(int regType) {
		this.regType = regType;
	}

	/**
	 * @return the regName
	 */
	public String getRegName() {
		return regName;
	}

	/**
	 * @param regName
	 *            the regName to set
	 */
	public void setRegName(String regName) {
		this.regName = regName;
	}

	@Override
	public int compareTo(Reginfo o) {
		//不排序
		return 0;
	}

}
