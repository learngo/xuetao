package com.taotaoti.party.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taotaoti.party.bo.Party;
import com.taotaoti.party.dao.PartyDao;
import com.taotaoti.party.service.PartyMgr;
@Component
public class PartyMgrImpl implements PartyMgr {
    
	@Resource
	public PartyDao partyDao;
	@Override
	public List<Party> findIndexPary(int curPage, int pageSize) {
		// TODO Auto-generated method stub
		return partyDao.findIndexPary(curPage, pageSize);
	}

	@Override
	public List<Party> findParyByMemberId(int memberId, int curPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return partyDao.findParyByMemberId(memberId, curPage, pageSize);
	}
	@Override
	public List<Party> findPary( int curPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return partyDao.findAll(curPage, pageSize);
	}

	@Override
	public void submitParty(int memberId, String icon, String title,
			String description, Timestamp startTime, Timestamp endTime) {

		Party party=new Party(memberId, title, description,
				startTime, endTime,
				0, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 
				icon, "", 0, 0, 0, "");
		partyDao.create(party);
	}

	@Override
	public void modifyPartyStatu(int memberId, int partyId, int statu) {
		Party party=partyDao.findPartyByMemberIdAndPartyId(memberId, partyId);
		if(party!=null){
			party.setState(statu);
			party.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			partyDao.update(party);
		}
	}
	@Override
	public void modifyPartyStatu( int partyId, int statu) {
		Party party=partyDao.get(partyId);
		if(party!=null){
			party.setState(statu);
			party.setUpdateTime(new Timestamp(System.currentTimeMillis()));
			partyDao.update(party);
		}
	}

	@Override
	public Party findPartyByMemberIdAndPartyId(int memberId, int partyId) {
		// TODO Auto-generated method stub
		return partyDao.findPartyByMemberIdAndPartyId(memberId, partyId);
	}
	

}
