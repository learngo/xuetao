package com.taotaoti.good.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.good.bo.GoodComment;
import com.taotaoti.good.dao.GoodCommentDao;

@Repository
public class GoodCommentDaoImpl extends AbstractDao<Integer, GoodComment> implements GoodCommentDao{
	
	 protected final static Log LOG = LogFactory.getLog(GoodCommentDaoImpl.class);

	@Override
	public GoodComment createGoodComment(GoodComment goodComment) {
		// TODO Auto-generated method stub
		return this.create(goodComment);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.counts();
	}
	
}
