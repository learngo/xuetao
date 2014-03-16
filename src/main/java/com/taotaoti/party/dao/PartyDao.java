
package com.taotaoti.party.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.party.bo.Party;

public interface PartyDao extends BaseDao<Integer, Party> {

	public List<Party> findAll();
	
	public Party createParty(Party party);

	public int counts();
}