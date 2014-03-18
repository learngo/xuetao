package com.taotaoti.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.category.bo.Category;
import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.BaseTestCase;
import com.taotaoti.member.bo.Auth;
import com.taotaoti.member.dao.AuthDao;

public class CategoryDaoTest extends BaseTestCase {
	
	@Resource
	private CategoryDao categorDao;
	
	@Test
	public void testfindAll(){
		List ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		//List<Auth> list= categorDao.findByAuthids(ids);
		//System.out.println(list.toArray(a));
	}
	@Test
	public void testModifyAuthCode(){
		//authDao.modifyAuthCode(1, "ADMIN_INDEX");
	}
	@Test
	public void testSaveCategory(){
//		Category category=new Category();
//		category.setName("自行车");
//		category.setOrderId(1);
//		category.setParentId(0);
//		category.setStatu(0);
//		Category m=categorDao.create(category);
	  List<Category>	a=categorDao.findAll();
		System.out.println(a.size());
	}
	
}
