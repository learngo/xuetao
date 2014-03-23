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

import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.constant.GoodConstant;
import com.taotaoti.good.service.GoodMgr;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.constant.MemberConstant;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.service.PartyMgr;
import com.taotaoti.school.bo.School;
import com.taotaoti.school.dao.SchoolDao;

@Controller
@RequestMapping(value="/admin")
public class ManagerController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ManagerController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberMgr memberMgr;
	@Resource
	private CategoryDao categoryDao;
	@Resource
	private PartyMgr partyMgr;
	@Resource
	private GoodMgr goodMgr;
	@Resource
	private SchoolDao schoolDao;
	
	@Resource
	private RedisCacheManager redisCacheMgr;
	

	@RequestMapping(value = "/addGood")
	public String addGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="goodId",required=false) Integer goodId,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
		listMaps.add(categorys);
		if(goodId!=null){
			listMaps.add(new MatchMap("goodView", goodMgr.getGoodViewByGoodId(v.getUserid(),goodId)));
			return this.buildSuccess(model, "/admin/viewGood", listMaps);
		}
		return this.buildSuccess(model, "/admin/addGood", listMaps);
	}
	@RequestMapping(value = "/browseGood")
	public String browseGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
		MatchMap goods=new MatchMap("goods", goodMgr.findAllGood(curPage, pageSize));
		listMaps.add(goods);
		return this.buildSuccess(model, "/admin/browseGood", listMaps);
	}
	@RequestMapping(value = "/deleteGood")
	public ModelAndView deleteGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="goodId") Integer goodId,
			ModelMap model){
		goodMgr.modifyGoodStatu( goodId, GoodConstant.GOOD_STATU_DELETE);
		return this.buildSuccessByRedirectOnlyUrl("/admin/browseGood");
	}
	
	
	@RequestMapping(value = "/party")
	public String party(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId",required=false) Integer partyId,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		MatchMap schooles=new MatchMap("schooles",schoolDao.findAll());
		listMaps.add(schooles);
		if(partyId!=null){
			Party party=partyMgr.findPartyByMemberIdAndPartyId(v.getUserid(), partyId);
			String schoolids=party.getSchoolIds();
			if(schoolids.length()>0&&!schooles.equals("")){
				String[] schIds=schoolids.split(",");
				if(schIds.length>0){
					School school=schoolDao.get(Integer.valueOf(schIds[0]));
					listMaps.add(new MatchMap("school",school));
				}
			}
			listMaps.add(new MatchMap("party",party));
			return this.buildSuccess(model, "/admin/viewParty", listMaps);
		}
		
		return this.buildSuccess(model, "/admin/addParty", listMaps);
	}
	
	@RequestMapping(value = "/browseParty")
	public String browseParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
		MatchMap partys=new MatchMap("partys", partyMgr.findPary(curPage, pageSize));
		listMaps.add(partys);
		return this.buildSuccess(model, "/admin/browseParty", listMaps);
	}
	@RequestMapping(value = "/deleteParty")
	public ModelAndView deleteParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			ModelMap model){
		partyMgr.modifyPartyStatu(partyId, 1);
		return this.buildSuccessByRedirectOnlyUrl("/admin/browseParty");
	}
	@RequestMapping(value = "/browseMember")
	public String browseMember(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null||curPage<0) curPage=0;
		if(pageSize==null) pageSize=12;
		MatchMap members=new MatchMap("members",memberMgr.browseAcountInfos());
		listMaps.add(members);
		return this.buildSuccess(model, "/admin/browseMember", listMaps);
	}
	@RequestMapping(value = "/deleteMember")
	public ModelAndView deleteMember(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="memberId") Integer memberId,
			ModelMap model){
		return this.buildSuccessByRedirectOnlyUrl("/admin/browseMember");
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
