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

import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.good.service.GoodMgr;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.party.service.PartyMgr;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private MemberDao memberDao;
	@Resource
	private CategoryDao categoryDao;
	@Resource
	private PartyMgr partyMgr;
	@Resource
	private GoodMgr goodMgr;
	
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	@RequestMapping(value = "/settings/settings")
	public String settings(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	MatchMap member=new MatchMap("member", memberDao.get(v.getUserid()));
		listMaps.add(member);
		listMaps.add(new MatchMap("v", v));
		return this.buildSuccess(model, "/member/settings/settings", listMaps);
	}
	@RequestMapping(value = "/settings/addGood")
	public String addGood(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
		listMaps.add(categorys);
		return this.buildSuccess(model, "/member/settings/addGood", listMaps);
	}
	@RequestMapping(value = "/settings/browseGood")
	public String browseGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
	 	Visitor v=this.session.getSessionVisitor(request);
		MatchMap goods=new MatchMap("goods", goodMgr.findGoodByMemberId(v.getUserid(), curPage, pageSize));
		listMaps.add(goods);
		return this.buildSuccess(model, "/member/settings/browseGood", listMaps);
	}
	@RequestMapping(value = "/settings/party")
	public String party(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
		listMaps.add(categorys);
		return this.buildSuccess(model, "/member/settings/addParty", listMaps);
	}
	@RequestMapping(value = "/settings/addParty")
	public String addParty(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		MatchMap categorys=new MatchMap("categorys", categoryDao.findAll());
		listMaps.add(categorys);
		return this.buildSuccess(model, "/member/settings/addParty", listMaps);
	}
	@RequestMapping(value = "/settings/browseParty")
	public String browseParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	if(curPage==null||curPage<0) curPage=0;
	 	if(pageSize==null) pageSize=12;
	 	Visitor v=this.session.getSessionVisitor(request);
		MatchMap partys=new MatchMap("partys", partyMgr.findParyByMemberId(v.getUserid(), curPage, pageSize));
		listMaps.add(partys);
		return this.buildSuccess(model, "/member/settings/browseParty", listMaps);
	}
	@RequestMapping(value = "/settings/modifyPassword")
	public String modifyPassword(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="oldPassword") String oldPassword,
			@RequestParam(value="newPassword") String newPassword,
			@RequestParam(value="newPassword2") String newPassword2,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		if(!newPassword.equals(newPassword2)){
			LOG.error("新密码与确认密码不一致");
			return this.buildBusinessError(model, "/member/settings/password", "新密码与确认密码不一致！");
		}
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(newPassword))){
			LOG.error("旧密码不正确！");
			return this.buildBusinessError(model, "/member/settings/password", "旧密码不正确！");
		}
		memberDao.modifyPassword(v.getUserid(), MD5.getMd5(newPassword));
		return this.buildSuccessOnlyUrl("/member/settings/settings");
	}
	
	@RequestMapping(value = "/settings/modifyEmail")
	public String modifyEmail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="password") String password,
			@RequestParam(value="newEmail") String newEmail,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(password))){
			LOG.error("旧密码不正确！");
			return this.buildBusinessError(model, "/member/settings/email", "旧密码不正确！");
		}
		memberDao.modifyEmail(v.getUserid(), newEmail);
		v.setEmail(newEmail);
		this.session.setAttributeAsVisitor(request, v);
		return this.buildSuccessOnlyUrl("/member/settings/settings");
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
