package com.taotaoti.good.vo;

import java.util.List;

import com.taotaoti.good.bo.GoodComment;
import com.taotaoti.good.bo.GoodCommentSub;


public class GoodCommentViewUtil{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static GoodCommentView toGoodCommentViewByGoodCommentAndSub(String memberName,GoodComment goodComment,List<GoodCommentSub> goodCommentSubs){
		GoodCommentView goodCommentView=new GoodCommentView();
		goodCommentView.setGoodCommentSubs(goodCommentSubs);
		goodCommentView.setMemberName(memberName);
		
		goodCommentView.setContent(goodComment.getContent());
		goodCommentView.setCreateTime(goodComment.getCreateTime());
		goodCommentView.setGoodCommentId(goodComment.getGoodCommentId());
		goodCommentView.setGoodId(goodComment.getGoodId());
		goodCommentView.setId(goodComment.getId());
		goodCommentView.setIsReply(goodComment.getIsReply());
		goodCommentView.setMemberId(goodComment.getMemberId());
		goodCommentView.setPhone(goodComment.getPhone());
		goodCommentView.setReplyContent(goodComment.getReplyContent());
		goodCommentView.setReplyMemberId(goodComment.getReplyMemberId());
		goodCommentView.setReplyTime(goodComment.getCreateTime());
		goodCommentView.setStatu(goodComment.getStatu());
		return goodCommentView;
	}

}
