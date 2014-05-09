package com.taotaoti.xuetao.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.StringUtils;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.bo.GoodComment;
import com.taotaoti.good.bo.GoodCommentSub;
import com.taotaoti.good.dao.GoodCommentDao;
import com.taotaoti.good.dao.GoodCommentSubDao;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.dao.GoodPicDao;
import com.taotaoti.good.service.GoodMgr;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.bo.Message;
import com.taotaoti.member.constant.MessageConstant;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.dao.MessageDao;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.member.vo.AcountInfo;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.dao.PartyDao;

@Controller
public class WebController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private PartyDao partyDao;
	@Resource
	private GoodDao goodDao;
	@Resource
	private GoodPicDao goodPicDao;
	@Resource
	private CategoryDao categoryDao;
	
	@Resource
	private GoodMgr goodMgr;
	@Resource
	private GoodCommentDao goodCommentDao;
	@Resource
	private GoodCommentSubDao goodCommentSubDao;
	@Resource
	private RedisCacheManager redisCacheMgr;
	@Resource
	private MemberMgr memberMgr;
	@Resource
	private MemberDao memberDao;
	@Resource
	private MessageDao messageDao;
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
//	 	MatchMap partys=new MatchMap("partys", partyDao.findIndexPary(0,4));
//		listMaps.add(partys);
		return this.buildSuccess(model, "/index", listMaps);
	}
	@RequestMapping(value = "/web/partys")
	public String partys(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) {
	 		curPage=0;
	 		listMaps.add(new MatchMap("isPre", 0));
	 	}
	 	if(pageSize==null) pageSize=12;
	 	List<Party> partyList= partyDao.findIndexPary(curPage,pageSize);
        MatchMap partys=new MatchMap("partys", partyList);
    	if(curPage>0){
    		listMaps.add(new MatchMap("isPre", 1));
    	}
    	
    	if(partyList.size()<12)
    		listMaps.add(new MatchMap("isNext", 0));
    	else
    		listMaps.add(new MatchMap("isNext", 1));
    	
		listMaps.add(partys);
		return this.buildSuccess(model, "/web/partys", listMaps);
	}
	@RequestMapping(value = "/web/goods")
	public String goods(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			@RequestParam(value="categoryId",required=false) Integer categoryId,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
        if(curPage==null||curPage<0) {
	 		curPage=0;
	 		listMaps.add(new MatchMap("isPre", 0));
	 	}
	 	if(pageSize==null) pageSize=12;
	 	List<Good> goodlist;
	 	if(categoryId==null){
	 		goodlist=goodDao.findIndexGood(curPage,pageSize);
			MatchMap goods=new MatchMap("goods", goodlist);
	        listMaps.add(goods);
	         
		}else{
			goodlist=goodDao.findIndexGood(curPage,pageSize,categoryId);
			MatchMap goods=new MatchMap("goods", goodlist);
			listMaps.add(goods);
			listMaps.add(new MatchMap("categoryId",categoryId));
			
		}
	 	
	 	if(goodlist.size()<12)
    		listMaps.add(new MatchMap("isNext", 0));
    	else
    		listMaps.add(new MatchMap("isNext", 1));
    	
	 	
		MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
		listMaps.add(categorys);
		return this.buildSuccess(model, "/web/goods", listMaps);
	}
	@RequestMapping(value = "/web/goodDetail")
	public String goodDetail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="goodId") Integer goodId,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		Good good=goodDao.get(goodId);
		MatchMap goodMap=new MatchMap("good", good);
		listMaps.add(goodMap);
		Member member=memberDao.get(good.getMemberId());
		MatchMap memberMatch=new MatchMap("member", member);
		listMaps.add(memberMatch);
		MatchMap goodPices=new MatchMap("goodPics", goodPicDao.findAllByGoodId(goodId));
		listMaps.add(goodPices);
		Visitor visitor=this.session.getSessionVisitor(request);
		if(visitor!=null){
			if(good.getMemberId()==visitor.getUserid()){
		      listMaps.add(new MatchMap("goodComments", goodMgr.findGoodComments(goodId)));
		      listMaps.add(new MatchMap("isManager", 1));
			}else{
				 listMaps.add(new MatchMap("isManager", 0));
		         listMaps.add(new MatchMap("goodComments", goodMgr.findGoodCommentsByMemberId(goodId, visitor.getUserid())));
			}
		}else
			 listMaps.add(new MatchMap("isManager", 0));
		return this.buildSuccess(model, "/web/goodDetail", listMaps);
	}
	@RequestMapping(value = "/web/replyContent")
	public ModelAndView replyContent(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="commentId") Integer commentId,
			@RequestParam(value="replyContent") String replyContent,
			ModelMap model){
		GoodComment goodComment=goodCommentDao.get(commentId);
		Good good=goodDao.get(goodComment.getGoodId());
		Visitor visitor=this.session.getSessionVisitor(request);
		if(visitor!=null){
			LOG.info(visitor.getUserid()+ " modify reply content"+ commentId+ "=="+replyContent);
			GoodCommentSub goodCommentSub=new GoodCommentSub();
			goodCommentSub.setCommentId(commentId);
			goodCommentSub.setContent(replyContent);
			goodCommentSub.setCreateTime(new Timestamp(System.currentTimeMillis()));
			goodCommentSub.setMemberId(visitor.getUserid());
			goodCommentSub.setMemberName(visitor.getUsername());
			goodCommentSub.setStatu(0);
			goodCommentSubDao.create(goodCommentSub);
			
			if(good.getMemberId()!=visitor.getUserid()){
				Message message=new Message();
				message.setMessageContent(replyContent);
				message.setMessageCreateTime(new Timestamp(System.currentTimeMillis()));
				message.setMessageMemberId(visitor.getUserid());
				message.setMessageMemberName(visitor.getUsername());
				message.setMessageProductId(good.getGoodId());
				message.setMessageType(MessageConstant.MESSAGE_PRODUCT_TYPE_GOOD);
				message.setMessageStatu(MessageConstant.MESSAGE_STATU_OK);
				messageDao.create(message);
				
				int messageSum=messageDao.countsByMessageMemberId(visitor.getUserid());
		        visitor.setMessageSum(messageSum);
				session.setAttributeAsVisitor(request, visitor);
			}
		}
		return this.buildSuccessByRedirectAndParam("/web/goodDetail", model, "goodId", goodComment.getGoodId());
	}
	
	
	@RequestMapping(value = "/web/page/partys")
	public String partys2(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null) curPage=0;
		if(pageSize==null) pageSize=12;
		MatchMap partys=new MatchMap("partys", partyDao.findIndexPary(curPage,pageSize));
		listMaps.add(partys);
		
		return this.buildSuccess(model, "/web/partys", listMaps);
	}
	@RequestMapping(value = "/web/search")
	public String search(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			@RequestParam(value="content") String content,
			@RequestParam(value="categoryType") Integer categoryType,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null) curPage=0;
		if(pageSize==null) pageSize=12;
		if(categoryType==null) categoryType=2;
		if(categoryType==2){
			MatchMap partys=new MatchMap("partys", partyDao.findParyByLike(content,curPage,pageSize));
			listMaps.add(partys);
			return this.buildSuccess(model, "/web/partys", listMaps);
		}else{
			 MatchMap goods=new MatchMap("goods", goodDao.findGoodLike(content,curPage,pageSize));
			 listMaps.add(goods);
			 MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
			 listMaps.add(categorys);
			return this.buildSuccess(model, "/web/goods", listMaps);
		}
	}
	
	
	
	
	@RequestMapping(value = "/web/partyDetail")
	public String partyDetail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		Party party=partyDao.get(partyId);
		MatchMap partyMatch=new MatchMap("party", party);
		MatchMap memberMatch=new MatchMap("member", memberMgr.getAcountInfoByMemberId(party.getMemberId()));
		listMaps.add(partyMatch);
		listMaps.add(memberMatch);
		ArrayList<AcountInfo> listAcountInfos=new ArrayList<AcountInfo>();
		if(party!=null){
			String []ids=party.getJoinMemberIds().split(",");
			if(ids.length>0){
				for(int i=0;i<ids.length;i++){
				    if(ids[i]!=""&&!StringUtils.isEmpty(ids[i])){
						int memberId=Integer.valueOf(ids[i]);
						listAcountInfos.add(memberMgr.getAcountInfoByMemberId(memberId));
				    }
				}
			}
		}
		listMaps.add(new MatchMap("acountInfos", listAcountInfos));
		return this.buildSuccess(model, "/web/partyDetail", listMaps);
	}
	@RequestMapping(value = "/web/leaveMessage")
	public String levelMessage(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		Party party=partyDao.get(partyId);
		MatchMap partyMatch=new MatchMap("party", party);
		MatchMap memberMatch=new MatchMap("member", memberMgr.getAcountInfoByMemberId(party.getMemberId()));
		listMaps.add(partyMatch);
		listMaps.add(memberMatch);
		ArrayList<AcountInfo> listAcountInfos=new ArrayList<AcountInfo>();
		if(party!=null){
			String []ids=party.getJoinMemberIds().split(",");
			if(ids.length>0){
				for(int i=0;i<ids.length;i++){
				    if(ids[i]!=""&&!StringUtils.isEmpty(ids[i])){
						int memberId=Integer.valueOf(ids[i]);
						listAcountInfos.add(memberMgr.getAcountInfoByMemberId(memberId));
				    }
				}
			}
		}
		listMaps.add(new MatchMap("acountInfos", listAcountInfos));
		
		 if(curPage==null||curPage<0) {
		 		curPage=0;
		 		listMaps.add(new MatchMap("isPre", 0));
		 	}
		if(pageSize==null) pageSize=12;
		List<Message> messageList=messageDao.findByProductTypeAndProductId(MessageConstant.MESSAGE_PRODUCT_TYPE_PARTY, partyId, curPage, pageSize);
		MatchMap messages=new MatchMap("messages",messageList);
		listMaps.add(messages);
		LOG.info("Message :"+messageList.size());
		if(messageList.size()<12)
    		listMaps.add(new MatchMap("isNext", 0));
    	else
    		listMaps.add(new MatchMap("isNext", 1));
		
		return this.buildSuccess(model, "/web/leaveMessage", listMaps);
	}
	
	@RequestMapping(value = "/viewMemberInfo")
	public String viewMemberInfo(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="memberId") Integer memberId,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		 if(memberId!=null){
		  listMaps.add(new MatchMap("acountInfos", memberMgr.getAcountInfoByMemberId(memberId)));
		  listMaps.add(new MatchMap("partys",partyDao.findParyByMemberId(memberId, 0, 10)));
		  listMaps.add(new MatchMap("goods",goodMgr.findGoodByMemberId(memberId, 0, 10)));
		  return this.buildSuccess(model, "/user", listMaps);
		 }else
			return this.buildSuccessOnlyUrl("/index");  
	}
	
	
	public SessionProvider getSession() {
		return session;
	}
	public void setSession(SessionProvider session) {
		this.session = session;
	}
	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}
	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}
}
