package com.taotaoti.good.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "good_comment_sub", keyColumn = GoodColumns.GoodCommentSubColumns.goodCommentSubId)
public class GoodCommentSub extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	
	@Column(value=GoodColumns.GoodCommentSubColumns.memberId)
	private Integer memberId;
	@Column(value=GoodColumns.GoodCommentSubColumns.commentId)
	private Integer commentId;
	@Column(value=GoodColumns.GoodCommentSubColumns.memberName)
	private String memberName;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Column(value=GoodColumns.GoodCommentSubColumns.content)
	private String content ;
	@Column(value=GoodColumns.GoodCommentSubColumns.statu)
	private Integer statu;
	@Column(value=GoodColumns.GoodCommentSubColumns.createTime)
	private Timestamp createTime ;
	
	public GoodCommentSub(){
		
	}
	public GoodCommentSub( Integer memberId,
			Integer commentId, String content, Integer statu,
			Timestamp createTime) {
		super();
		this.memberId = memberId;
		this.commentId = commentId;
		this.content = content;
		this.statu = statu;
		this.createTime = createTime;
	}
	
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
