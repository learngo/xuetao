
package com.taotaoti.good.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.good.bo.GoodPic;

public interface GoodPicDao extends BaseDao<Integer, GoodPic> {

	public List<GoodPic> findAll();
	public List<GoodPic> findAllByGoodId(int goodId);
	
	public GoodPic createGoodPic(GoodPic goodPic);

	public int counts();
}