
package com.taotaoti.party.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.party.bo.Party;

public interface PartyDao extends BaseDao<Integer, Party> {

	public List<Party> findAll();
	
	public Party createParty(Party party);
	public int counts();
	public List<Party> findAll(int curPage,
			int pageSize);
	public List<Party> findIndexPary( int curPage,
			int pageSize);
	public List<Party> findParyByLike(String content, int curPage,
			int pageSize);
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize);
	public Party findPartyByMemberIdAndPartyId(int memberId,int partyId);
}