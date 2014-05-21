
package com.taotaoti.message.dao;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.message.bo.Notification;

public interface NotificationDao extends BaseDao<Integer, Notification> {
	public Notification findOne(int memberId);
	public int modifyCount(int count,String evaluateIds,int notiId);
	public int modifyCountByMemberId(int count,String evaluateIds,int memberId);
}