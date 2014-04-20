package com.taotaoti.xuetao.controller;

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

import com.taotaoti.category.bo.Category;
import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.StringUtils;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.dao.GoodPicDao;
import com.taotaoti.good.service.GoodMgr;
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
	private RedisCacheManager redisCacheMgr;
	@Resource
	private MemberMgr memberMgr;
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	MatchMap partys=new MatchMap("partys", partyDao.findIndexPary(0,4));
		listMaps.add(partys);
		return this.buildSuccess(model, "/index", listMaps);
	}
	@RequestMapping(value = "/web/partys")
	public String partys(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
        MatchMap partys=new MatchMap("partys", partyDao.findIndexPary(curPage,pageSize));
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
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
	 	if(categoryId==null){
         MatchMap goods=new MatchMap("goods", goodDao.findIndexGood(curPage,pageSize));
		 listMaps.add(goods);
		}else{
			MatchMap goods=new MatchMap("goods", goodDao.findIndexGood(curPage,pageSize,categoryId));
			listMaps.add(goods);
			listMaps.add(new MatchMap("categoryId",categoryId));
		}
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
		MatchMap good=new MatchMap("good", goodDao.get(goodId));
		listMaps.add(good);
		MatchMap goodPices=new MatchMap("goodPics", goodPicDao.findAllByGoodId(goodId));
		listMaps.add(goodPices);
		listMaps.add(new MatchMap("goodComments", goodMgr.findGoodComments(goodId)));
		return this.buildSuccess(model, "/web/goodDetail", listMaps);
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
	@RequestMapping(value = "/web/partyDetail")
	public String partyDetail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		Party party=partyDao.get(partyId);
		MatchMap partyMatch=new MatchMap("party", party);
		listMaps.add(partyMatch);
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
