package com.taotaoti.good.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.good.bo.GoodColumns.GoodPicColumns;
import com.taotaoti.good.bo.GoodPic;
import com.taotaoti.good.constant.GoodConstant;
import com.taotaoti.good.dao.GoodPicDao;

@Repository
public class GoodPicDaoImpl extends AbstractDao<Integer, GoodPic> implements GoodPicDao{
	
	 protected final static Log LOG = LogFactory.getLog(GoodPicDaoImpl.class);

	@Override
	public GoodPic createGoodPic(GoodPic goodPic) {
		// TODO Auto-generated method stub
		return this.create(goodPic);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.counts();
	}

	@Override
	public List<GoodPic> findAllByGoodId(int goodId) {
		return this.find(match(GoodPicColumns.goodId, goodId));
	}
	
}
