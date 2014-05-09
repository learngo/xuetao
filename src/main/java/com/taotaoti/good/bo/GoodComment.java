package com.taotaoti.good.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "Good_Comment", keyColumn = GoodColumns.GoodCommentColumns.goodCommentId)
public class GoodComment extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=GoodColumns.GoodCommentColumns.goodCommentId)
	private Integer goodCommentId;
	@Column(value=GoodColumns.GoodCommentColumns.memberId)
	private Integer memberId;
	@Column(value=GoodColumns.GoodCommentColumns.memberName)
	private String memberName;
	@Column(value=GoodColumns.GoodCommentColumns.goodId)
	private Integer goodId;
	@Column(value=GoodColumns.GoodCommentColumns.content)
	private String content ;
	@Column(value=GoodColumns.GoodCommentColumns.phone)
	private String phone ;
	@Column(value=GoodColumns.GoodCommentColumns.statu)
	private Integer statu;
	@Column(value=GoodColumns.GoodCommentColumns.createTime)
	private Timestamp createTime ;
	@Column(value=GoodColumns.GoodCommentColumns.replyMemberId)
	private Integer replyMemberId;
	@Column(value=GoodColumns.GoodCommentColumns.isReply)
	private Integer isReply;
	@Column(value=GoodColumns.GoodCommentColumns.replyContent)
	private String replyContent;
	@Column(value=GoodColumns.GoodCommentColumns.replyTime)
	private Timestamp replyTime ;
	
	
	
	
	
	
	
	
	public GoodComment(Integer goodCommentId, Integer memberId,String memberName, Integer goodId,
			String content,String phone, String replyContent, Timestamp createTime,
			Integer replyMemberId, Integer isReply, Integer statu,
			Timestamp replyTime) {
		super();
		this.goodCommentId = goodCommentId;
		this.memberId = memberId;
		this.memberName=memberName;
		this.goodId = goodId;
		this.content = content;
		this.phone = phone;
		this.statu = statu;
		this.createTime = createTime;
		this.replyMemberId = replyMemberId;
		this.isReply = isReply;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
	}








	public String getPhone() {
		return phone;
	}








	public void setPhone(String phone) {
		this.phone = phone;
	}








	public GoodComment(){
		
	}








	







	public Integer getGoodCommentId() {
		return goodCommentId;
	}








	public void setGoodCommentId(Integer goodCommentId) {
		this.goodCommentId = goodCommentId;
	}








	public Integer getMemberId() {
		return memberId;
	}








	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}








	public Integer getGoodId() {
		return goodId;
	}








	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}








	public String getContent() {
		return content;
	}








	public void setContent(String content) {
		this.content = content;
	}








	public Integer getStatu() {
		return statu;
	}








	public void setStatu(Integer statu) {
		this.statu = statu;
	}








	public Timestamp getCreateTime() {
		return createTime;
	}








	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}








	public Integer getReplyMemberId() {
		return replyMemberId;
	}








	public void setReplyMemberId(Integer replyMemberId) {
		this.replyMemberId = replyMemberId;
	}








	public String getMemberName() {
		return memberName;
	}








	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}








	public Integer getIsReply() {
		return isReply;
	}








	public void setIsReply(Integer isReply) {
		this.isReply = isReply;
	}








	public String getReplyContent() {
		return replyContent;
	}








	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}








	public Timestamp getReplyTime() {
		return replyTime;
	}








	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}








	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
