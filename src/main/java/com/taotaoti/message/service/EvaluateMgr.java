package com.taotaoti.message.service;

import java.util.List;

import com.taotaoti.message.bo.Evaluate;
import com.taotaoti.message.bo.EvaluateComment;
import com.taotaoti.message.bo.Notification;


public interface EvaluateMgr {
	//public int clearNoti(int memberId);
	//public Notification findNotificationByMemberId(int memberId);
	//public Notification additionNotification(int memberId,int evaluateId);
	public List<Evaluate> findEvaluate(int evaluateProductType,int evaluateProductId,int memberId );
	public List<Evaluate> findEvaluate(int evaluateProductType,int evaluateProductId);
	public List<Evaluate> findEvaluateByEvaluateProductMemberId(int memberId);
	public int  countNoReadEvaluateByEvaluateProductMemberId(int memberId);
	public List<Evaluate> findEvaluateByids(List<Integer> ids);
	public Evaluate findEvaluate(int evaluateId);
	public List<EvaluateComment> findEvaluateComment(int evaluateId);
	public Evaluate addEvaluate(int memberId,int evaluateProductType,int evaluateProductId,int evaluateProductMemberId ,String content,String remark);
	public void deleteEvaluate(int evaluateId,int statu);
	public EvaluateComment addEvaluateComment(int memberId,int evaluateId,String content);
}
