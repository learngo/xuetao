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
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.dao.GoodDao;
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
	private CategoryDao categoryDao;
	@Resource
	private RedisCacheManager redisCacheMgr;
	
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
		MatchMap party=new MatchMap("party", partyDao.get(partyId));
		listMaps.add(party);
		return this.buildSuccess(model, "/web/partyDetail", listMaps);
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
