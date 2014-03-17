
package com.taotaoti.good.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.good.bo.Good;
import com.taotaoti.party.bo.Party;

public interface GoodDao extends BaseDao<Integer, Good> {

	public List<Good> findAll();
	
	public Good createGood(Good good);

	public int counts();
	public List<Good> findIndexGood( int curPage,
			int pageSize);
}