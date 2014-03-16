package com.taotaoti.party.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.party.bo.Party;
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
		return this.counts();
	}
	
}
