package com.taotaoti.good.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taotaoti.cache.AppCache;
import com.taotaoti.category.bo.Category;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.bo.GoodComment;
import com.taotaoti.good.bo.GoodCommentSub;
import com.taotaoti.good.bo.GoodPic;
import com.taotaoti.good.dao.GoodCommentDao;
import com.taotaoti.good.dao.GoodCommentSubDao;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.dao.GoodPicDao;
import com.taotaoti.good.service.GoodMgr;
import com.taotaoti.good.vo.GoodCommentView;
import com.taotaoti.good.vo.GoodCommentViewUtil;
import com.taotaoti.good.vo.GoodView;
@Component
public class GoodMgrImpl implements GoodMgr {
    
	@Resource
	public GoodDao goodDao;
	@Resource
	public GoodPicDao goodPicDao;
	@Resource
	public GoodCommentDao goodCommentDao;
	@Resource
	public GoodCommentSubDao goodCommentSubDao;
	@Resource
	public AppCache appCache;

	@Override
	public List<GoodView> findGoodByMemberId(int memberId, int curPage, int pageSize) {
		// TODO Auto-generated method stub
		List<GoodView> goodViews=new ArrayList<GoodView>();
		List<Good> goods=goodDao.findGoodByMemberId(memberId, curPage, pageSize);
		for(Good good:goods){
			GoodView goodView=toGoodView(good);
			goodViews.add(goodView);
		}
		return goodViews;
	}

	@Override
	public Good submitGood(int caregoryId,String name,String title,String description,String logo,int memberId,int level,int price) {
		Good good=new Good(null, 1, name, title, description, 
				new Timestamp(System.currentTimeMillis()),  new Timestamp(System.currentTimeMillis()), 
				0, logo, 0, memberId, price, level);
		return goodDao.create(good);
	}

	@Override
	public GoodView getGoodViewByGoodId(int memberId,int goodId) {
		Good good=goodDao.findGoodByMemberIdAndGoodId(memberId,goodId);
		if(good==null)
			return null;
		return toGoodView(good);
	}
	protected GoodView toGoodView(Good good) {
		Category category=appCache.getCategoryCache().get(good.getCategoryId());
		double price=good.getPrice()/100;
		String level;
		switch (good.getLevel()) {
		case 1:
			level="brand new";
			break;
		case 2:
			level="barely used";
			break;
		case 3:
			level="used";
			break;

		default:
			level="used";
			break;
		}
		GoodView goodView=GoodView.toGoodView(good, category.getName(), price, level);
		return goodView;
	}

	@Override
	public boolean modifyGoodStatu(int memberId, int goodId,int goodStatu) {
		Good good=goodDao.findGoodByMemberIdAndGoodId(memberId, goodId);
		if(good!=null){
			good.setStatu(goodStatu);
			goodDao.update(good);
			return true;
		}else{
		  return false; 
		}
		
	}
	@Override
	public boolean modifyGoodStatu(int goodId,int goodStatu) {
		Good good=goodDao.get(goodId);
		if(good!=null){
			good.setStatu(goodStatu);
			goodDao.update(good);
			return true;
		}else{
			return false; 
		}
		
	}

	@Override
	public List<GoodView> findAllGood(int curPage, int pageSize) {
		List<GoodView> goodViews=new ArrayList<GoodView>();
		List<Good> goods=goodDao.findAllPage(curPage, pageSize);
		for(Good good:goods){
			GoodView goodView=toGoodView(good);
			goodViews.add(goodView);
		}
		return goodViews;
	}

	@Override
	public boolean submitGoodPic(int goodId, String path) {
		GoodPic goodPic=new  GoodPic();
		goodPic.setDescription(null);
		goodPic.setGoodId(goodId);
		goodPic.setPath(path);
		goodPic.setStatu(0);
		goodPicDao.create(goodPic);
		return false;
	}

	@Override
	public boolean commintGoodComment(int memberId,String memberName,int goodId, String message,String phone) {
		GoodComment comment=new GoodComment(null, memberId, memberName,goodId, message,phone,"", new Timestamp(System.currentTimeMillis()), 0,0, 0, null);
		goodCommentDao.create(comment);
		return false;
	}

	@Override
	public List<GoodCommentView> findGoodComments(int goodId) {
		List<GoodComment> goodComments=goodCommentDao.findByGoodId(goodId);
		List<GoodCommentView> goodCommentViews=new ArrayList<GoodCommentView>();
		for(GoodComment goodComment:goodComments){
			List<GoodCommentSub> goodCommentSubs=goodCommentSubDao.findByGoodCommentId(goodComment.getId());
		    GoodCommentView goodCommentView=GoodCommentViewUtil.toGoodCommentViewByGoodCommentAndSub("", goodComment, goodCommentSubs);
		     goodCommentViews.add(goodCommentView); 		
		}
		return goodCommentViews;
	}
	@Override
	public List<GoodCommentView> findGoodCommentsByMemberId(int goodId,int memberId) {
		List<GoodComment> goodComments=goodCommentDao.findByGoodId(goodId,memberId);
		List<GoodCommentView> goodCommentViews=new ArrayList<GoodCommentView>();
		for(GoodComment goodComment:goodComments){
			List<GoodCommentSub> goodCommentSubs=goodCommentSubDao.findByGoodCommentId(goodComment.getId());
		    GoodCommentView goodCommentView=GoodCommentViewUtil.toGoodCommentViewByGoodCommentAndSub("", goodComment, goodCommentSubs);
		     goodCommentViews.add(goodCommentView); 		
		}
		return goodCommentViews;
	}

	@Override
	public boolean modifyGoodBuyerName(int memberId, int goodId,
			String buyerName) {
		Good good=goodDao.findGoodByMemberIdAndGoodId(memberId, goodId);
		if(good!=null){
			good.setBuyerName(buyerName);
			goodDao.update(good);
			return true;
		}else{
		  return false; 
		}
	}
	

}
