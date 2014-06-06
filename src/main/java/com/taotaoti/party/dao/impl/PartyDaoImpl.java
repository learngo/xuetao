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
import com.taotaoti.party.constant.PartyConstant;
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
		return this.count(match(PartyColumns.state, not(PartyConstant.PARTY_STATU_DELETE)));
	}

	@Override
	public List<Party> findIndexPary(int curPage,
			 int pageSize) {
		// TODO Auto-generated method stub
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(PartyColumns.state, true));
		orders.add(order(PartyColumns.partyId, false));
		matchs.add(match(PartyColumns.state, not(PartyConstant.PARTY_STATU_DELETE)));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	@Override
	public List<Party> findAll(int curPage,
			int pageSize) {
		return this.findAllPage(curPage, pageSize);
	}

	@Override
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(PartyColumns.state, true));
		orders.add(order(PartyColumns.partyId, false));
		matchs.add(match(PartyColumns.state, not(PartyConstant.PARTY_STATU_DELETE)));
		matchs.add(match(PartyColumns.memberId, memberId));
		return this.page(matchs,orders, curPage,
				pageSize);
	}

	@Override
	public Party findPartyByMemberIdAndPartyId(int memberId, int partyId) {
		// TODO Auto-generated method stub
		return findOne(match(PartyColumns.memberId,memberId),match(PartyColumns.partyId, partyId));
	}

	@Override
	public List<Party> findParyByLike(String content, int curPage, int pageSize) {
		List<Match> matchs=new ArrayList<Match>();
		List<Order> orders=new ArrayList<Order>();
		orders.add(order(PartyColumns.state, true));
		orders.add(order(PartyColumns.partyId, false));
		matchs.add(match(PartyColumns.state, not(PartyConstant.PARTY_STATU_DELETE)));
		matchs.add(match(PartyColumns.title,like(content)));
		return this.page(matchs,orders, curPage,
				pageSize);
	}
	
}
