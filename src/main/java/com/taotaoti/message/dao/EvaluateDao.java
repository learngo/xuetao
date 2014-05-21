
package com.taotaoti.message.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.message.bo.Evaluate;

public interface EvaluateDao extends BaseDao<Integer, Evaluate> {
	public Evaluate findOne(int evaluateId);
	public List<Evaluate> find(List<Integer> ids);
	public List<Evaluate> find(int evaluateProductType,int evaluateProductId,int memberId);
	public List<Evaluate> find(int evaluateProductType,int evaluateProductId);
	public List<Evaluate> findByEvaluateProductMemberId(int evaluateProductMemberId);
	public List<Evaluate> findByMemberId(int memberId);
	//public List<Evaluate> findBySql(int e);
	
	public int modifyReplyCount(int replyCount,int evaluateId);
	public int modifyStatu(int statu,int evaluateId);
}