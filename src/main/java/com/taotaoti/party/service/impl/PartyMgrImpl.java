package com.taotaoti.party.service.impl;

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
	

}
