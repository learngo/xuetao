package com.taotaoti.message.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.common.generic.dao.operator.Order;
import com.taotaoti.message.bo.Evaluate;
import com.taotaoti.message.bo.EvaluateColumns;
import com.taotaoti.message.dao.EvaluateDao;

@Repository
public class EvaluateDaoImpl extends AbstractDao<Integer, Evaluate> implements EvaluateDao{
	
	 protected final static Log LOG = LogFactory.getLog(EvaluateDaoImpl.class);

	@Override
	public Evaluate findOne(int evaluateId) {
		// TODO Auto-generated method stub
		return this.get(evaluateId);
	}

	@Override
	public List<Evaluate> find(List<Integer> ids) {
		return this.get(ids);
	}

	@Override
	public List<Evaluate> find(int evaluateProductType, int evaluateProductId,
			int memberId) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(EvaluateColumns.createTime, false));
		matchs.add(match(EvaluateColumns.evaluateProductId, evaluateProductId));
		matchs.add(match(EvaluateColumns.evaluateProductType, evaluateProductType));
		matchs.add(match(EvaluateColumns.memberId, memberId));
		return this.find(matchs,orders);
	}
	@Override
	public List<Evaluate> find(int evaluateProductType, int evaluateProductId) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(EvaluateColumns.createTime, false));
		matchs.add(match(EvaluateColumns.evaluateProductId, evaluateProductId));
		matchs.add(match(EvaluateColumns.evaluateProductType, evaluateProductType));
		return this.find(matchs,orders);
	}

	@Override
	public int modifyReplyCount(int replyCount,int evaluateId) {
		return this.update(modify(EvaluateColumns.replyCount, replyCount), match(EvaluateColumns.evaluateId, evaluateId));
	}
	@Override
	public int modifyStatu(int statu,int evaluateId) {
		return this.update(modify(EvaluateColumns.statu, statu), match(EvaluateColumns.evaluateId, evaluateId));
	}

	@Override
	public List<Evaluate> findByEvaluateProductMemberId(
			int evaluateProductMemberId) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(EvaluateColumns.createTime, false));
		matchs.add(match(EvaluateColumns.evaluateProductMemberId, evaluateProductMemberId));
		return this.find(matchs,orders);
	}

	@Override
	public List<Evaluate> findByMemberId(int memberId) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(EvaluateColumns.createTime, false));
		matchs.add(match(EvaluateColumns.memberId, memberId));
		return this.find(matchs,orders);
	}
	
}
