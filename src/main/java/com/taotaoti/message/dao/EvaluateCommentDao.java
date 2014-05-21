
package com.taotaoti.message.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.message.bo.EvaluateComment;

public interface EvaluateCommentDao extends BaseDao<Integer, EvaluateComment> {
	 public List<EvaluateComment> findByEvaluateId(int evaluateId);
	 public int modifyStatu(int statu,int evaluateCommentId);
}