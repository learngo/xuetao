package com.taotaoti.party.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.common.generic.dao.operator.Order;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.bo.PartyColumns;
import com.taotaoti.party.dao.PartyDao;

@Repository
public class PartyDaoImpl extends AbstractDao<Integer, Party> implements PartyDao{
	
	 protected final static Log LOG = LogFactory.getLog(PartyDaoImpl.class);

	@Override
	public Party createParty(Party party) {
		// TODO Auto-generated method stub
		return this.create(party);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.count(match(PartyColumns.state, 0));
	}

	@Override
	public List<Party> findIndexPary(int curPage,
			 int pageSize) {
		// TODO Auto-generated method stub
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(PartyColumns.partyId, false));
		matchs.add(match(PartyColumns.state, 0));
		return this.page(matchs,orders, curPage,
				pageSize);
	}

	@Override
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(PartyColumns.partyId, false));
		matchs.add(match(PartyColumns.state, 0));
		matchs.add(match(PartyColumns.memberId, memberId));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	
}
