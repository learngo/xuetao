package com.taotaoti.party.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "party", keyColumn = PartyColumns.partyId)
public class Party extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=PartyColumns.memberId)
	private Integer memberId;
	@Column(value=PartyColumns.title)
	private String title ;
	@Column(value=PartyColumns.description)
	private String description;
	@Column(value=PartyColumns.startTime)
	private Timestamp startTime;
	@Column(value=PartyColumns.endTime)
	private Timestamp endTime ;
	@Column(value=PartyColumns.state)
	private String state = "state";
	@Column(value=PartyColumns.createTime)
	private Timestamp createTime ;
	@Column(value=PartyColumns.updateTime)
	private Timestamp updateTime ;
	@Column(value=PartyColumns.icon)
	private String icon ;
	@Column(value=PartyColumns.schoolIds)
	private String schoolIds;
	@Column(value=PartyColumns.joinSum)
	private Integer joinSum ;
	@Column(value=PartyColumns.maxSum)
	private Integer maxSum;
	@Column(value=PartyColumns.ponit)
	private Integer ponit ;
	@Column(value=PartyColumns.joinMemberIds)
	private String joinMemberIds;
	
	
	

	public Party() {
	}




	public Party(Integer memberId, String title, String description,
			Timestamp startTime, Timestamp endTime, String state,
			Timestamp createTime, Timestamp updateTime, String icon,
			String schoolIds, Integer joinSum, Integer maxSum, Integer ponit,
			String joinMemberIds) {
		super();
		this.memberId = memberId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.icon = icon;
		this.schoolIds = schoolIds;
		this.joinSum = joinSum;
		this.maxSum = maxSum;
		this.ponit = ponit;
		this.joinMemberIds = joinMemberIds;
	}




	public Integer getMemberId() {
		return memberId;
	}




	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Timestamp getStartTime() {
		return startTime;
	}




	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}




	public Timestamp getEndTime() {
		return endTime;
	}




	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public Timestamp getCreateTime() {
		return createTime;
	}




	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}




	public Timestamp getUpdateTime() {
		return updateTime;
	}




	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}




	public String getIcon() {
		return icon;
	}




	public void setIcon(String icon) {
		this.icon = icon;
	}




	public String getSchoolIds() {
		return schoolIds;
	}




	public void setSchoolIds(String schoolIds) {
		this.schoolIds = schoolIds;
	}




	public Integer getJoinSum() {
		return joinSum;
	}




	public void setJoinSum(Integer joinSum) {
		this.joinSum = joinSum;
	}




	public Integer getMaxSum() {
		return maxSum;
	}




	public void setMaxSum(Integer maxSum) {
		this.maxSum = maxSum;
	}




	public Integer getPonit() {
		return ponit;
	}




	public void setPonit(Integer ponit) {
		this.ponit = ponit;
	}




	public String getJoinMemberIds() {
		return joinMemberIds;
	}




	public void setJoinMemberIds(String joinMemberIds) {
		this.joinMemberIds = joinMemberIds;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
