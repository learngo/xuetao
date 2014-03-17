package com.taotaoti.good;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.bo.GoodPic;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.dao.GoodPicDao;

public class GoodPicDaoTest extends BaseTestCase {
	
	@Resource
	private GoodPicDao goodPicDao;
	@Resource
	private GoodDao goodDao;
	
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
	
	@Test
	public void testSaveGood(){
		Good good=new Good(1, 1, "name", "title", "description", new Timestamp(System.currentTimeMillis()),  new Timestamp(System.currentTimeMillis()), 0, "", 0, 1, 11, 1);
		goodDao.create(good);
	}
	
}
