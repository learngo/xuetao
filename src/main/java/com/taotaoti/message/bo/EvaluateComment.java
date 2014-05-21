package com.taotaoti.message.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "evaluate_comment", keyColumn = EvaluateCommentColumns.evaluateCommentId)
public class EvaluateComment extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=EvaluateCommentColumns.memberId)
	private Integer memberId;
	@Column(value="ignore")
	private String memberName;
	@Column(value=EvaluateCommentColumns.evaluateId)
	private Integer evaluateId;
	@Column(value=EvaluateCommentColumns.content)
	private String content ;
	@Column(value=EvaluateCommentColumns.statu)
	private Integer statu;
	@Column(value=EvaluateCommentColumns.createTime)
	private Timestamp createTime ;
	public EvaluateComment() {
	}
	public EvaluateComment(Integer evaluateCommentId,Integer memberId, Integer evaluateId,
			String content, Integer statu, Timestamp createTime) {
		super();
		this.id=evaluateCommentId;
		this.memberId = memberId;
		this.evaluateId = evaluateId;
		this.content = content;
		this.statu = statu;
		this.createTime = createTime;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
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
	
}
