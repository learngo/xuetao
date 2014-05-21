package com.taotaoti.message.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Modify;
import com.taotaoti.message.bo.Notification;
import com.taotaoti.message.bo.NotificationColumns;
import com.taotaoti.message.dao.NotificationDao;

@Repository
public class NotificationDaoImpl extends AbstractDao<Integer, Notification> implements NotificationDao{
	
	 protected final static Log LOG = LogFactory.getLog(NotificationDaoImpl.class);

	@Override
	public Notification findOne(int memberId) {
		return this.findOne(match(NotificationColumns.memberId, memberId));
	}
	@Override
	public int modifyCount(int count,String evaluateIds, int notiId) {
		List<Modify> modifies=new ArrayList<Modify>();
		modifies.add(modify(NotificationColumns.count, count));
		modifies.add(modify(NotificationColumns.evaluateIds, evaluateIds));
		return this.update(modifies, match(NotificationColumns.notiId, notiId));
	}
	@Override
	public int modifyCountByMemberId(int count,String evaluateIds, int memberId) {
		List<Modify> modifies=new ArrayList<Modify>();
		modifies.add(modify(NotificationColumns.count, count));
		modifies.add(modify(NotificationColumns.evaluateIds, evaluateIds));
		return this.update(modifies, match(NotificationColumns.memberId, memberId));
	}
}
