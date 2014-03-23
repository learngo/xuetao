package com.taotaoti.good.service;

import java.util.List;

import com.taotaoti.good.vo.GoodView;


public interface GoodMgr {
	public List<GoodView> findAllGood(int curPage,
			int pageSize);
	public List<GoodView> findGoodByMemberId(int memberId, int curPage,
			int pageSize);
	public void submitGood(int caregoryId,String name,String title,String description,String logo,int memberId,int level,int price) ;
	public GoodView getGoodViewByGoodId(int memberId,int goodId);
	public boolean modifyGoodStatu(int goodId,int goodStatu);
	public boolean modifyGoodStatu(int memberId,int goodId,int goodStatu);

}
