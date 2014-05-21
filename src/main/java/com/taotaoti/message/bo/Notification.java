package com.taotaoti.message.bo;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "notification", keyColumn = NotificationColumns.notiId)
public class Notification extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=NotificationColumns.memberId)
	private Integer memberId;
	@Column(value=NotificationColumns.count)
	private Integer count;
	@Column(value=NotificationColumns.evaluateIds)
	private String evaluateIds;

	public Notification() {
	}

	public Notification(Integer notiId,Integer memberId, Integer count, String evaluateIds) {
		super();
		this.id=notiId;
		this.memberId = memberId;
		this.count = count;
		this.evaluateIds = evaluateIds;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getEvaluateIds() {
		return evaluateIds;
	}

	public void setEvaluateIds(String evaluateIds) {
		this.evaluateIds = evaluateIds;
	}


}
