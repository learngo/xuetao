package com.taotaoti.good.service;

import java.util.List;

import com.taotaoti.good.bo.Good;


public interface GoodMgr {
	public List<Good> findGoodByMemberId(int memberId, int curPage,
			int pageSize);
	

}
