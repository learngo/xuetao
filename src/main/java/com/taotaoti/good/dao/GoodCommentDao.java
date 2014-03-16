
package com.taotaoti.good.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.good.bo.GoodComment;

public interface GoodCommentDao extends BaseDao<Integer, GoodComment> {

	public List<GoodComment> findAll();
	
	public GoodComment createGoodComment(GoodComment goodComment);

	public int counts();
}