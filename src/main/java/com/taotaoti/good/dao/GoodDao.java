
package com.taotaoti.good.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.good.bo.Good;

public interface GoodDao extends BaseDao<Integer, Good> {

	public List<Good> findAll();
	public List<Good> findAllPage(int curPage,
			int pageSize);
	
	public Good createGood(Good good);

	public int counts();
	public List<Good> findIndexGood( int curPage,
			int pageSize);
	public List<Good> findGoodByMemberId(int memberId, int curPage,
			int pageSize);

	public List<Good> findIndexGood(int curPage, int pageSize, int categoryId);
	
	public Good findGoodByMemberIdAndGoodId(int memberId,int goodId);
}