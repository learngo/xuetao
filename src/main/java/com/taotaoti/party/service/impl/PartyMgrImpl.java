package com.taotaoti.party.service.impl;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taotaoti.good.bo.Good;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.dao.PartyDao;
import com.taotaoti.party.service.PartyMgr;
@Component
public class PartyMgrImpl implements PartyMgr {
    
	@Resource
	public PartyDao partyDao;
	@Resource
	public MemberDao memberDao;
	@Override
	public List<Party> findIndexPary(int curPage, int pageSize) {
        List<Party> parties=partyDao.findIndexPary(curPage, pageSize);
		HashMap<Integer, Member> memberIds=new HashMap<Integer, Member>(); 
		if(parties!=null){
			for(Party party:parties){
				memberIds.put(party.getMemberId(),null);
			}
		}
		Collection c=memberIds.keySet();
		List<Member>  members=memberDao.findByMemberIds(c);
		for(Member member:members){
			memberIds.put(member.getId(),member);
		}
		for(int i=0;i<parties.size();i++){
			Party party=parties.get(i);
			parties.get(i).setMemberPhoto(memberIds.get(party.getMemberId()).getPhoto());
		}
		return parties;
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
		
		return partyDao.findAll(curPage, pageSize);
	}

	@Override
	public void submitParty(int memberId, String icon, String title,
			String description, Timestamp startTime, Timestamp endTime,String address) {

		Party party=new Party(memberId, title, description,
				startTime, endTime,
				0, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 
				icon, "", 0, 0, 0, "",address);
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
		return partyDao.findPartyByMemberIdAndPartyId(memberId, partyId);
	}
	

}
