package com.taotaoti.party;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.good.bo.GoodPic;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.dao.PartyDao;

public class PartyDaoTest extends BaseTestCase {
	
	@Resource
	private PartyDao partyDao;
	
	
	@Test
	public void testSaveGoodPic(){
		Party party=new Party(1, "title", "description",
				new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()),
				0, new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()), 
				"/web/logo.jpg", "1", 0, 0, 0, "");
		partyDao.create(party);
	}
	
}
