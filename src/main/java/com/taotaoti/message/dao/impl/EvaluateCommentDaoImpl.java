package com.taotaoti.message.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.common.generic.dao.operator.Order;
import com.taotaoti.message.bo.EvaluateComment;
import com.taotaoti.message.bo.EvaluateCommentColumns;
import com.taotaoti.message.dao.EvaluateCommentDao;

@Repository
public class EvaluateCommentDaoImpl extends AbstractDao<Integer, EvaluateComment> implements EvaluateCommentDao{
	 protected final static Log LOG = LogFactory.getLog(EvaluateCommentDaoImpl.class);
	 @Override
	 public List<EvaluateComment> findByEvaluateId(int evaluateId){
		 List<Match> matchs=new ArrayList<Match>();
			List<Order> orders=new ArrayList<Order>();
			orders.add(order(EvaluateCommentColumns.createTime, false));
			matchs.add(match(EvaluateCommentColumns.evaluateId, evaluateId));
			return this.find(matchs,orders);
	 }
	@Override
	public int modifyStatu(int statu, int evaluateCommentId) {
		return this.update(modify(EvaluateCommentColumns.statu, statu), match(EvaluateCommentColumns.evaluateCommentId, evaluateCommentId));
	}
}
