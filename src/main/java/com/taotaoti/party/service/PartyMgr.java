package com.taotaoti.party.service;

import java.sql.Timestamp;
import java.util.List;

import com.taotaoti.party.bo.Party;


public interface PartyMgr {
	public List<Party> findIndexPary( int curPage,
			int pageSize);
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize);
	public List<Party> findPary(int curPage,
			int pageSize);
	public void submitParty(int memberId,String icon,String title,String description,Timestamp startTime,Timestamp endTime,String address);
	public void modifyPartyStatu(int memberId,int partyId,int statu);
	public void modifyPartyStatu(int partyId,int statu);
	public Party findPartyByMemberIdAndPartyId(int memberId,int partyId);
	

}
