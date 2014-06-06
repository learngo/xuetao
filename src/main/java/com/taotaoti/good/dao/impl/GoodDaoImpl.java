package com.taotaoti.good.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.common.generic.dao.operator.Order;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.bo.GoodColumns;
import com.taotaoti.good.constant.GoodConstant;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.member.bo.Columns;
import com.taotaoti.party.bo.PartyColumns;

@Repository
public class GoodDaoImpl extends AbstractDao<Integer, Good> implements GoodDao{
	
	 protected final static Log LOG = LogFactory.getLog(GoodDaoImpl.class);

	@Override
	public Good createGood(Good good) {
		// TODO Auto-generated method stub
		return this.create(good);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.counts();
	}

	@Override
	public List<Good> findIndexGood(int curPage, int pageSize) {
		// TODO Auto-generated method stub
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(GoodColumns.statu, true));
		orders.add(order(GoodColumns.goodId, false));
		matchs.add(match(GoodColumns.statu, not(GoodConstant.GOOD_STATU_DELETE)));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	@Override
	public List<Good> findGoodByMemberId(int memberId,int curPage, int pageSize) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(GoodColumns.statu, true));
		orders.add(order(GoodColumns.goodId, false));
		matchs.add(match(GoodColumns.statu, not(GoodConstant.GOOD_STATU_DELETE)));
		matchs.add(match(GoodColumns.memberId, memberId));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	@Override
	public List<Good> findIndexGood(int curPage, int pageSize,int categoryId) {
		// TODO Auto-generated method stub
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(GoodColumns.statu, true));
		orders.add(order(GoodColumns.goodId, false));
		matchs.add(match(GoodColumns.statu, not(GoodConstant.GOOD_STATU_DELETE)));
		matchs.add(match(GoodColumns.categoryId, categoryId));
		return this.page(matchs,orders, curPage,
				pageSize);
	}

	@Override
	public Good findGoodByMemberIdAndGoodId(int memberId, int goodId) {
		
		return this.findOne(match(GoodColumns.memberId, memberId),match(GoodColumns.goodId, goodId));
	}

	@Override
	public List<Good> findGoodLike(String content, int curPage, int pageSize) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(GoodColumns.statu, true));
		orders.add(order(GoodColumns.goodId, false));
		matchs.add(match(GoodColumns.statu, not(GoodConstant.GOOD_STATU_DELETE)));
		matchs.add(match(GoodColumns.title, like(content)));
		return this.page(matchs,orders, curPage,
				pageSize);
	}

	@Override
	public void modifyGoodClickSum(Integer goodId, int sum) {
		update(modify(GoodColumns.clickSum, sum), match(GoodColumns.goodId, goodId));
	}

	@Override
	public void modifyGoodBuyerName(Integer goodId, String buyerName) {
		update(modify(GoodColumns.buyerName, buyerName), match(GoodColumns.goodId, goodId));
		
	}
	
}
