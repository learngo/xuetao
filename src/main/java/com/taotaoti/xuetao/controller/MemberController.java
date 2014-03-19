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

import com.taotaoti.category.bo.Category;
import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.dao.GoodDao;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.party.dao.PartyDao;

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
