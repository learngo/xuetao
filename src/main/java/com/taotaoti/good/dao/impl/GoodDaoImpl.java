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
import com.taotaoti.good.dao.GoodDao;
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
		orders.add(order(GoodColumns.goodId, false));
		matchs.add(match(GoodColumns.statu, 0));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	
}