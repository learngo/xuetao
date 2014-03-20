package com.taotaoti.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taotaoti.good.bo.Good;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.service.GoodMgr;
@Component
public class GoodMgrImpl implements GoodMgr {
    
	@Resource
	public GoodDao goodDao;

	@Override
	public List<Good> findGoodByMemberId(int memberId, int curPage, int pageSize) {
		// TODO Auto-generated method stub
		return goodDao.findGoodByMemberId(memberId, curPage, pageSize);
	}
	

}
