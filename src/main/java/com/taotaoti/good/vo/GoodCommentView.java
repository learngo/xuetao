package com.taotaoti.good.vo;

import java.util.List;

import com.taotaoti.good.bo.GoodComment;
import com.taotaoti.good.bo.GoodCommentSub;

public class GoodCommentView extends GoodComment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String memberName;
	List<GoodCommentSub> goodCommentSubs;
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public List<GoodCommentSub> getGoodCommentSubs() {
		return goodCommentSubs;
	}
	public void setGoodCommentSubs(List<GoodCommentSub> goodCommentSubs) {
		this.goodCommentSubs = goodCommentSubs;
	}
	

}
