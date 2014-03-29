package com.taotaoti.good.vo;

import com.taotaoti.good.bo.GoodComment;

public class GoodCommentView extends GoodComment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	String memberName;

}
