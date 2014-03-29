/*******************************************************************************
 * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
 * Filename:    AdviewBaseTest.java
 * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
 * Create-Date: 2013-5-8 下午5:29:30
 *******************************************************************************/
package com.taotaoti.member;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.BTools;
import com.taotaoti.school.bo.School;
import com.taotaoti.school.dao.SchoolDao;

public class SchoolDaoTest extends BaseTestCase {
	
	@Resource
	private SchoolDao schoolDao;
	
	@Test
	public void testfindAll(){
		System.out.println(schoolDao.get(1).getName());
	}
	@Test
	public void testSchool(){
	ArrayList<String> lines=(ArrayList<String>) BTools.readFileByLines("school.txt");
	System.out.println(lines.size());
	for(String schoolName:lines){
		School school=new School(schoolName, "", 0);
		schoolDao.create(school);
	}
	
	}
}
