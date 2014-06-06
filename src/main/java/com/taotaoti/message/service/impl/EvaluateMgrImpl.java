package com.taotaoti.message.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.jdbc2.optional.MysqlXid;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.message.bo.Evaluate;
import com.taotaoti.message.bo.EvaluateComment;
import com.taotaoti.message.bo.Notification;
import com.taotaoti.message.constant.EvaluateConstant;
import com.taotaoti.message.dao.EvaluateCommentDao;
import com.taotaoti.message.dao.EvaluateDao;
import com.taotaoti.message.dao.NotificationDao;
import com.taotaoti.message.service.EvaluateMgr;
import com.taotaoti.xuetao.controller.MemberController;
@Component
public class EvaluateMgrImpl implements EvaluateMgr {
	private static final Logger LOG = LoggerFactory.getLogger(EvaluateMgrImpl.class);
	@Resource
	NotificationDao notificationDao;
	@Resource
	EvaluateDao evaluateDao;
	@Resource
	EvaluateCommentDao evaluateCommentDao;
	@Resource
	MemberDao memberDao;
	@Override
	public int clearNoti(int memberId) {
		Notification notification=notificationDao.findOne(memberId);
		if(notification==null){
			notification=new Notification();
			notification.setCount(0);
			notification.setEvaluateIds("");
			notification.setMemberId(memberId);
			notificationDao.create(notification);
			return 0;
		}
		return notificationDao.modifyCountByMemberId(0,"", memberId);
	}

	@Override
	public Notification findNotificationByMemberId(int memberId) {
		Notification notification=notificationDao.findOne(memberId);
		if(notification==null){
			notification=new Notification();
			notification.setCount(0);
			notification.setEvaluateIds("");
			notification.setMemberId(memberId);
			notification=notificationDao.create(notification);
		}
		return notification;
	}

	@Override
	public Evaluate findEvaluate(int evaluateId) {
		Evaluate e=this.evaluateDao.findOne(evaluateId);
		Member member=memberDao.get(e.getMemberId());
		e.setMemberName(member.getName());
		List<EvaluateComment> evaluateComments=this.evaluateCommentDao.findByEvaluateId(e.getId());
		HashMap<Integer, String> memberIds=new HashMap<Integer, String>();
		for(int i=0;i<evaluateComments.size();i++){
			memberIds.put(evaluateComments.get(i).getMemberId(), "");
		}
		
		List<Member> members=memberDao.get(memberIds.keySet());
		if(members!=null){
			for(Member m:members){
				if(memberIds.containsKey(m.getId())){
					memberIds.put(m.getId(), m.getName());
				}
			}
			for(int i=0;i<evaluateComments.size();i++){
				evaluateComments.get(i).setMemberName(memberIds.get(evaluateComments.get(i).getMemberId()));
			}
		}
		e.setEvaluateComments(evaluateComments);
		return e;
	}
	@Override
	public List<Evaluate> findEvaluate(int evaluateProductType,
			int evaluateProductId, int memberId) {
		List<Evaluate> evaluates=this.evaluateDao.find(evaluateProductType, evaluateProductId, memberId);
		HashMap<Integer, String> memberIds=new HashMap<Integer, String>();
		for(int i=0;i<evaluates.size();i++){
			memberIds.put(evaluates.get(i).getMemberId(), "");
		}
		List<Member> members=memberDao.get(memberIds.keySet());
		if(members!=null){
				for(Member member:members){
			
				if(memberIds.containsKey(member.getId())){
					memberIds.put(member.getId(), member.getName());
				}
			}
			for(int i=0;i<evaluates.size();i++){
				evaluates.get(i).setMemberName(memberIds.get(evaluates.get(i).getMemberId()));
			}
		}

		return evaluates;
	}
	@Override
	public List<Evaluate> findEvaluate(int evaluateProductType,
			int evaluateProductId) {
		List<Evaluate> evaluates=this.evaluateDao.find(evaluateProductType, evaluateProductId);
		LOG.info("size" + evaluates.size());
		HashMap<Integer, String> memberIds=new HashMap<Integer, String>();
		for(int i=0;i<evaluates.size();i++){
			memberIds.put(evaluates.get(i).getMemberId(), "");
		}
		List<Member> members=memberDao.get(memberIds.keySet());
		if(members!=null){
		for(Member member:members){
			if(memberIds.containsKey(member.getId())){
				memberIds.put(member.getId(), member.getName());
			}
		}
		for(int i=0;i<evaluates.size();i++){
			evaluates.get(i).setMemberName(memberIds.get(evaluates.get(i).getMemberId()));
		}
	}
//		for(int i=0;i<evaluates.size();i++){
//			Evaluate e=evaluates.get(i);
//			evaluates.get(i).setEvaluateComments(this.evaluateCommentDao.findByEvaluateId(e.getId()));
//		}
		return evaluates;
	}


	@Override
	public List<EvaluateComment> findEvaluateComment(int evaluateId) {
		List<EvaluateComment> evaluateComments=	this.evaluateCommentDao.findByEvaluateId(evaluateId);
		HashMap<Integer, String> memberIds=new HashMap<Integer, String>();
		for(int i=0;i<evaluateComments.size();i++){
			memberIds.put(evaluateComments.get(i).getMemberId(), "");
		}
		List<Member> members=memberDao.get(memberIds.keySet());
		if(members!=null){
			for(Member member:members){
				if(memberIds.containsKey(member.getId())){
					memberIds.put(member.getId(), member.getName());
				}
			}
			for(int i=0;i<evaluateComments.size();i++){
				evaluateComments.get(i).setMemberName(memberIds.get(evaluateComments.get(i).getMemberId()));
			}
		}
		return evaluateComments;
	}

	@Override
	@Transactional
	public Evaluate addEvaluate(int memberId, int evaluateProductType,
			int evaluateProductId, int evaluateProductMemberId,String content, String remark) {
		Evaluate evaluate=new Evaluate();
		evaluate.setContent(content);
		evaluate.setMemberId(memberId);
		evaluate.setCreateTime(new Timestamp(System.currentTimeMillis()));
		evaluate.setEvaluateProductId(evaluateProductId);
		evaluate.setEvaluateProductType(evaluateProductType);
		evaluate.setEvaluateProductMemberId(evaluateProductMemberId);
		evaluate.setStatu(EvaluateConstant.EVALUATE_STATU_OK);
		evaluate.setReplyCount(0);
		evaluate.setRemark(remark);
		evaluate.setEvaluateWorth(5);
		return this.evaluateDao.create(evaluate);
	}
	@Override
	public void deleteEvaluate(int evaluateId, int statu) {
		this.evaluateDao.modifyStatu(statu, evaluateId);
	}

	@Override
	public Notification additionNotification(int memberId,int evaluateId) {
		Notification notification=notificationDao.findOne(memberId);
		if(notification==null){
			notification=new Notification();
			notification.setCount(1);
			notification.setEvaluateIds(""+evaluateId);
			notification.setMemberId(memberId);
			notificationDao.create(notification);
		}else{
			notification.setCount(notification.getCount()+1);
			notification.setEvaluateIds(notification.getEvaluateIds()+"|"+evaluateId);
			notificationDao.modifyCount(notification.getCount(),notification.getEvaluateIds() ,notification.getId());
		}
		return notification;
	}

	@Override
	@Transactional
	public EvaluateComment addEvaluateComment(int memberId,int evaluateId, String content) {
		EvaluateComment evaluateComment=new EvaluateComment();
		evaluateComment.setContent(content);
		evaluateComment.setMemberId(memberId);
		evaluateComment.setStatu(EvaluateConstant.EVALUATE_COMMENT_STATU_OK);
		evaluateComment.setEvaluateId(evaluateId);
		evaluateComment.setCreateTime(new Timestamp(System.currentTimeMillis()));
		Evaluate evaluate=evaluateDao.get(evaluateId);
		if(evaluate.getReplyCount()==null)
			evaluate.setReplyCount(0);
		evaluateDao.modifyReplyCount(evaluate.getReplyCount()+1, evaluateId);
		return evaluateCommentDao.create(evaluateComment);
	}

	@Override
	public List<Evaluate> findEvaluateByEvaluateProductMemberId(int memberId) {
		return this.evaluateDao.findByEvaluateProductMemberId(memberId);
	}

	@Override
	public List<Evaluate> findEvaluateByids(List<Integer> ids) {
		return this.evaluateDao.find(ids);
	}
}
