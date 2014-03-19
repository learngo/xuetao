/*******************************************************************************
 * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
 * Filename:    AdviewBaseTest.java
 * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
 * Create-Date: 2013-5-8 下午5:29:30
 *******************************************************************************/
package com.taotaoti.member;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.bo.Role;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.facade.MemberFacade;
import com.taotaoti.member.vo.AcountInfo;
import com.taotaoti.school.dao.SchoolDao;

public class SchoolDaoTest extends BaseTestCase {
	
	@Resource
	private SchoolDao schoolDao;
	
	@Test
	public void testfindAll(){
		System.out.println(schoolDao.get(1).getName());
	}
}
