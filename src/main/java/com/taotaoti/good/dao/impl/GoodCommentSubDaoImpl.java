package com.taotaoti.good.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.good.bo.GoodColumns.GoodCommentColumns;
import com.taotaoti.good.bo.GoodColumns.GoodCommentSubColumns;
import com.taotaoti.good.bo.GoodCommentSub;
import com.taotaoti.good.dao.GoodCommentSubDao;

@Repository
public class GoodCommentSubDaoImpl extends AbstractDao<Integer, GoodCommentSub> implements GoodCommentSubDao{
	
	 protected final static Log LOG = LogFactory.getLog(GoodCommentSubDaoImpl.class);

	@Override
	public GoodCommentSub createGoodCommentSub(GoodCommentSub goodCommentSub) {
		return this.create(goodCommentSub);
	}

	@Override
	public int counts() {
		return this.counts();
	}
	
	@Override
	public List<GoodCommentSub> findByGoodCommentId(int goodCommentId) {
		return this.find(match(GoodCommentSubColumns.commentId, goodCommentId),match(GoodCommentColumns.statu, 0));
	}
	
	
}
