package com.taotaoti.good.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.dao.GoodDao;

@Repository
public class GoodDaoImpl extends AbstractDao<Integer, Good> implements GoodDao{
	
	 protected final static Log LOG = LogFactory.getLog(GoodDaoImpl.class);

	@Override
	public Good createGood(Good good) {
		// TODO Auto-generated method stub
		return this.create(good);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.counts();
	}
	
}
