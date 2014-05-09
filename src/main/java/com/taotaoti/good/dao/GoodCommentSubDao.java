
package com.taotaoti.good.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.good.bo.GoodCommentSub;

public interface GoodCommentSubDao extends BaseDao<Integer, GoodCommentSub> {

	public List<GoodCommentSub> findAll();
	public List<GoodCommentSub> findByGoodCommentId(int goodCommentId);
	public GoodCommentSub createGoodCommentSub(GoodCommentSub goodCommentSub);
	public int counts();
	
	
}