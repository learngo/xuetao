package com.taotaoti.good;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.good.bo.GoodPic;
import com.taotaoti.good.dao.GoodPicDao;

public class GoodPicDaoTest extends BaseTestCase {
	
	@Resource
	private GoodPicDao goodPicDao;
	
	@Test
	public void testfindAll(){
		goodPicDao.findAll();
		//System.out.println(list.toArray(a));
	}
	
	@Test
	public void testSaveGoodPic(){
		GoodPic entity=new GoodPic();
		entity.setDescription("description");
		entity.setGoodId(1);
		entity.setPath("/picke/ad");
		entity.setStatu(0);
		entity.setTitle("title");
		goodPicDao.create(entity);
	}
	
}
