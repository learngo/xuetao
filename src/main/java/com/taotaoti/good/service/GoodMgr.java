package com.taotaoti.good.service;

import java.util.List;

import com.taotaoti.good.bo.Good;
import com.taotaoti.good.vo.GoodCommentView;
import com.taotaoti.good.vo.GoodView;


public interface GoodMgr {
	public List<GoodView> findAllGood(int curPage,
			int pageSize);
	public List<GoodView> findGoodByMemberId(int memberId, int curPage,
			int pageSize);
	public Good submitGood(int caregoryId,String name,String title,String description,String logo,int memberId,int level,int price) ;
	public GoodView getGoodViewByGoodId(int memberId,int goodId);
	public Good getGoodByGoodId(int goodId);
	public boolean modifyGoodStatu(int goodId,int goodStatu);
	public boolean modifyGoodStatu(int memberId,int goodId,int goodStatu);
	public boolean modifyGoodBuyerName(int memberId,int goodId,String buyerName);
	public boolean submitGoodPic(int goodId,String path);
	
	public boolean commintGoodComment(int memberId,String memberName,int goodId,String message,String phone);
	public List<GoodCommentView> findGoodComments(int goodId);
	public List<GoodCommentView> findGoodCommentsByMemberId(int goodId,int memberId);

}
