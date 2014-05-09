package com.taotaoti.good.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.good.bo.GoodColumns.GoodCommentColumns;
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
	@Override
	public List<GoodComment> findByGoodId(int goodId) {
		
		return this.find(match(GoodCommentColumns.goodId, goodId),match(GoodCommentColumns.statu, 0));
	}
	@Override
	public List<GoodComment> findByGoodId(int goodId,int memberId) {
//        String sql = "select * from xuetao.Good_Comment where goodId = ? and member_id =? and modtime >? and modtime<=?" ;
//		
//		List<Object> params = new ArrayList<Object>();
//		params.add(dspId);
//		params.add(state);
//		params.add(start);
//		params.add(end);
//		return this.findBySQL(sql, params);
		return this.find(match(GoodCommentColumns.goodId, goodId),
				match(GoodCommentColumns.memberId, memberId),
				match(GoodCommentColumns.statu, 0));
	}
	
}
