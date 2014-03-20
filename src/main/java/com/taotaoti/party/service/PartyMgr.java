package com.taotaoti.party.service;

import java.util.List;

import com.taotaoti.party.bo.Party;


public interface PartyMgr {
	public List<Party> findIndexPary( int curPage,
			int pageSize);
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize);
	

}
