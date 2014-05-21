package com.taotaoti.message.bo;

import java.sql.Timestamp;
import java.util.List;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "evaluate", keyColumn = EvaluateColumns.evaluateId)
public class Evaluate extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=EvaluateColumns.memberId)
	private Integer memberId;
	@Column(value="ignore")
	private String memberName;
	@Column(value=EvaluateColumns.evaluateProductType)
	private Integer evaluateProductType;
	@Column(value=EvaluateColumns.evaluateProductId)
	private Integer evaluateProductId ;
	@Column(value=EvaluateColumns.evaluateProductMemberId)
	private Integer evaluateProductMemberId ;
	@Column(value=EvaluateColumns.evaluateWorth)
	private Integer evaluateWorth;
	@Column(value=EvaluateColumns.content)
	private String content;
	@Column(value=EvaluateColumns.statu)
	private Integer statu ;
	@Column(value=EvaluateColumns.createTime)
	private Timestamp createTime ;
	@Column(value=EvaluateColumns.replyCount)
	private Integer replyCount;
	@Column(value=EvaluateColumns.remark)
	private String remark;
	@Column(value="ignore")
	private List<EvaluateComment> evaluateComments;
	public Evaluate() {
	}

	public Evaluate(Integer evaluateId,Integer memberId, Integer evaluateProductType,
			Integer evaluateProductId,Integer evaluateProductMemberId ,Integer evaluateWorth, String content,
			Integer statu, Timestamp createTime, Integer replyCount,String remark) {
		super();
		this.id=evaluateId;
		this.memberId = memberId;
		this.evaluateProductType = evaluateProductType;
		this.evaluateProductId = evaluateProductId;
		this.evaluateProductMemberId=evaluateProductMemberId;
		this.evaluateWorth = evaluateWorth;
		this.content = content;
		this.statu = statu;
		this.createTime = createTime;
		this.replyCount = replyCount;
		this.remark=remark;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public List<EvaluateComment> getEvaluateComments() {
		return evaluateComments;
	}

	public void setEvaluateComments(List<EvaluateComment> evaluateComments) {
		this.evaluateComments = evaluateComments;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getEvaluateProductType() {
		return evaluateProductType;
	}

	public void setEvaluateProductType(Integer evaluateProductType) {
		this.evaluateProductType = evaluateProductType;
	}

	public Integer getEvaluateProductId() {
		return evaluateProductId;
	}

	public void setEvaluateProductId(Integer evaluateProductId) {
		this.evaluateProductId = evaluateProductId;
	}

	public Integer getEvaluateWorth() {
		return evaluateWorth;
	}

	public void setEvaluateWorth(Integer evaluateWorth) {
		this.evaluateWorth = evaluateWorth;
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

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getEvaluateProductMemberId() {
		return evaluateProductMemberId;
	}

	public void setEvaluateProductMemberId(Integer evaluateProductMemberId) {
		this.evaluateProductMemberId = evaluateProductMemberId;
	}

	

}
