package com.taotaoti.xuetao.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.DateUtils;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.utils.StringUtils;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.good.bo.Good;
import com.taotaoti.good.constant.GoodConstant;
import com.taotaoti.good.service.GoodMgr;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.member.vo.AcountInfo;
import com.taotaoti.party.bo.Party;
import com.taotaoti.party.dao.PartyDao;
import com.taotaoti.party.service.PartyMgr;
import com.taotaoti.school.bo.School;
import com.taotaoti.school.dao.SchoolDao;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
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
	private PartyDao partyDao;
	@Resource
	private SchoolDao schoolDao;
	
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
		listMaps.add(new MatchMap("path", "/member/settings/settings"));
		listMaps.add(new MatchMap("pathName", "settings"));
		
		return this.buildSuccess(model, "/member/settings/settings", listMaps);
	}
	@RequestMapping(value = "/settings/password")
	public String password(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/password"));
		listMaps.add(new MatchMap("pathName", "password"));
		return this.buildSuccess(model, "/member/settings/password", listMaps);
	}
	@RequestMapping(value = "/settings/email")
	public String email(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/email"));
		listMaps.add(new MatchMap("pathName", "email"));
		return this.buildSuccess(model, "/member/settings/email", listMaps);
	}
	@RequestMapping(value = "/settings/addParty")
	public String addParty(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/addParty"));
		listMaps.add(new MatchMap("pathName", "addParty"));
		return this.buildSuccess(model, "/member/settings/addParty", listMaps);
	}
	
	@RequestMapping(value = "/settings/addGood")
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
			return this.buildSuccess(model, "/member/settings/viewGood", listMaps);
		}
		listMaps.add(new MatchMap("path", "/member/settings/addGood"));
		listMaps.add(new MatchMap("pathName", "addGood"));
		return this.buildSuccess(model, "/member/settings/addGood", listMaps);
	}
	@RequestMapping(value = "/settings/submitGood")
	public ModelAndView submitGood(HttpServletRequest request,
			HttpServletResponse response,
			Good good,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		String ctxPath = request.getSession().getServletContext().getRealPath("/")
				+ File.separator + "resources"+ File.separator +"upload"+ File.separator +"good"+ File.separator;
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		if(!file.isEmpty()){
			String realFileName = file.getOriginalFilename();
			System.out.println(file.getName());
			if(!realFileName.endsWith(".jpg"))
			    return this.buildErrorByRedirectAndParam("/member/settings/addGood", model, "图片格式不对！");
		    
			realFileName=""+v.getUserid()+System.currentTimeMillis()+MD5.getMd5(realFileName)+".jpg";
			File uploadFile = new File(ctxPath + realFileName);
			try {
				FileCopyUtils.copy(file.getBytes(), uploadFile);
				good.setLogo("/resources/upload/good/"+realFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
			return this.buildErrorByRedirectAndParam("/member/settings/addGood",model,"Logo is null!");
		if(good.getTitle()==null)
			return this.buildErrorByRedirectAndParam("/member/settings/addGood",model,"title is null!");
		if(good.getName()==null)
			return this.buildErrorByRedirectAndParam("/member/settings/addGood",model,"name is null!");
		if(good.getPrice()==null)
			return this.buildErrorByRedirectAndParam("/member/settings/addGood",model,"price is null!");
		
		Good goodOk=goodMgr.submitGood(good.getCategoryId(),good.getName(),good.getTitle(), good.getDescription(), good.getLogo(),v.getUserid(),good.getLevel(),good.getPrice());
		
		MultipartFile file1 = multipartRequest.getFile("file1");
		if(!file1.isEmpty()){
			String fileName1 = file1.getOriginalFilename();
			if(fileName1!=null&&fileName1.endsWith(".jpg")){
				fileName1=""+v.getUserid()+System.currentTimeMillis()+MD5.getMd5(fileName1)+".jpg";
				File uploadFile1 = new File(ctxPath + fileName1);
				try {
					FileCopyUtils.copy(file1.getBytes(), uploadFile1);
					goodMgr.submitGoodPic(goodOk.getId(), "/resources/upload/good/"+fileName1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		MultipartFile file2 = multipartRequest.getFile("file2");
		if(!file1.isEmpty()){
		String fileName2 = file2.getOriginalFilename();
		if(fileName2!=null&&fileName2.endsWith(".jpg")){
			fileName2=""+v.getUserid()+System.currentTimeMillis()+MD5.getMd5(fileName2)+".jpg";
			File uploadFile2 = new File(ctxPath + fileName2);
			try {
				FileCopyUtils.copy(file2.getBytes(), uploadFile2);
				goodMgr.submitGoodPic(goodOk.getId(), "/resources/upload/good/"+fileName2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		MultipartFile file3 = multipartRequest.getFile("file3");
		if(!file3.isEmpty()){
		String fileName3 = file3.getOriginalFilename();
		if(fileName3!=null&&fileName3.endsWith(".jpg")){
			fileName3=""+v.getUserid()+System.currentTimeMillis()+MD5.getMd5(fileName3)+".jpg";
			File uploadFile3 = new File(ctxPath + fileName3);
			try {
				FileCopyUtils.copy(file3.getBytes(), uploadFile3);
				goodMgr.submitGoodPic(goodOk.getId(), "/resources/upload/good/"+fileName3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/browseGood");
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
		listMaps.add(new MatchMap("path", "/member/settings/browseGood"));
		listMaps.add(new MatchMap("pathName", "browseGood"));
		return this.buildSuccess(model, "/member/settings/browseGood", listMaps);
	}
	@RequestMapping(value = "/settings/deleteGood")
	public ModelAndView deleteGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="goodId") Integer goodId,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		goodMgr.modifyGoodStatu(v.getUserid(), goodId, GoodConstant.GOOD_STATU_DELETE);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/browseGood");
	}
	@RequestMapping(value = "/addGoodMessage")
	public ModelAndView addGoodMessage(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="message") String message,
			@RequestParam(value="phone") String phone,
			@RequestParam(value="goodId") Integer goodId,
			ModelMap model){
		Visitor visitor=this.session.getSessionVisitor(request);
		goodMgr.commintGoodComment(visitor.getUserid(),visitor.getUsername(), goodId, message,phone);
		return this.buildSuccessByRedirectAndParam("/web/goodDetail", model, "goodId", goodId);
	}
	
	@RequestMapping(value = "/settings/party")
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
			return this.buildSuccess(model, "/member/settings/viewParty", listMaps);
		}
		
		return this.buildSuccess(model, "/member/settings/addParty", listMaps);
	}
	
	
	
	@RequestMapping(value = "/settings/submitParty")
	public ModelAndView addParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="schoolId",required=true) Integer schoolId,
			@RequestParam(value="title",required=true) String title,
			@RequestParam(value="description",required=true) String description,
			@RequestParam(value="startTime",required=true) String start,
			@RequestParam(value="endTime",required=true) String end,
			ModelMap model){
		String icon="";
		Visitor v=this.session.getSessionVisitor(request);
		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 根据前台的name名称得到上传的文件
		MultipartFile file = multipartRequest.getFile("file");
		if(!file.isEmpty()){
			// 获得文件名：
			String realFileName = file.getOriginalFilename();
			// 获取路径
			String ctxPath = request.getSession().getServletContext().getRealPath("/")
					+ File.separator + "resources"+ File.separator +"upload"+ File.separator +"party"+ File.separator;
			// 创建文件
			File dirPath = new File(ctxPath);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
			
			if(!realFileName.endsWith(".jpg"))
			    return this.buildErrorByRedirectAndParam("/member/settings/party", model, "图片格式不对！");
		    
			realFileName=""+v.getUserid()+System.currentTimeMillis()+MD5.getMd5(realFileName)+".jpg";
			File uploadFile = new File(ctxPath + realFileName);
			try {
				LOG.info(ctxPath);
				FileCopyUtils.copy(file.getBytes(), uploadFile);
				icon=("/resources/upload/party/"+realFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Timestamp startTime;
		Timestamp endTime;
		if(start!=null)
			startTime=new Timestamp(DateUtils.parseDate(start, "yyyy-MM-dd HH:mm:ss").getTime());
		else
			startTime=new Timestamp(System.currentTimeMillis());
		if(end!=null) 
			endTime=new Timestamp(DateUtils.parseDate(end, "yyyy-MM-dd HH:mm:ss").getTime());
		else{
			Date date=new Date(startTime.getTime());
			endTime=new Timestamp(DateUtils.getNextDay(date, 90l).getTime());
		}
		Date date=new Date(startTime.getTime());
		if(endTime.getTime() > DateUtils.getNextDay(date, 91l).getTime()){
			
		}
		
		partyMgr.submitParty(v.getUserid(), icon, title, description, startTime, endTime);
		AcountInfo a=memberMgr.getAcountInfoByMemberId(visitor.getUserid());
		memberDao.modifyCreatePartySum(v.getUserid(), a.getPartyCreateSum()+1);
		
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/browseParty");
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
		listMaps.add(new MatchMap("path", "/member/settings/browseParty"));
		listMaps.add(new MatchMap("pathName", "browseParty"));
		return this.buildSuccess(model, "/member/settings/browseParty", listMaps);
	}
	@RequestMapping(value = "/settings/deleteParty")
	public ModelAndView deleteParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		partyMgr.modifyPartyStatu(v.getUserid(), partyId, 1);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/browseParty");
	}
	@RequestMapping(value = "/settings/modifyPassword")
	public ModelAndView modifyPassword(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="oldPassword") String oldPassword,
			@RequestParam(value="newPassword") String newPassword,
			@RequestParam(value="newPassword2") String newPassword2,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		if(!newPassword.equals(newPassword2)){
			LOG.error("新密码与确认密码不一致");
			return this.buildErrorByRedirectAndParam("/member/settings/password", model, "New password and confirm new password fields do not match");
		}
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(oldPassword))){
			LOG.error("旧密码不正确！");
			return this.buildErrorByRedirectAndParam( "/member/settings/password",model, "The specified old password is incorrect for changing the password！");
		}
		memberDao.modifyPassword(v.getUserid(), MD5.getMd5(newPassword));
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	
	@RequestMapping(value = "/settings/modifyEmail")
	public ModelAndView modifyEmail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="password") String password,
			@RequestParam(value="newEmail") String newEmail,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(password))){
			LOG.error("旧密码不正确！");
			return this.buildErrorByRedirectAndParam( "/member/settings/email",model, "The  password is incorrect for changing ！");
		}
	    if(memberMgr.isRegisterMember(newEmail, "")){
	    	return this.buildErrorByRedirectAndParam( "/member/settings/email",model, "email is exist");
	    }
		memberDao.modifyEmail(v.getUserid(), newEmail);
		v.setEmail(newEmail);
		this.session.setAttributeAsVisitor(request, v);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	@RequestMapping(value = "/settings/modifyMemberInfo")
	public ModelAndView modifyMemberInfo(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("major") String major, 
			@RequestParam("phone") String phone, 
			@RequestParam("username") String username, 
			@RequestParam("description") String description, 
			ModelMap model){
		LOG.info("modify Member Info");
		Visitor v=this.session.getSessionVisitor(request);
		Member member=memberDao.get(v.getUserid());
		member.setMajor(major);
		member.setPhone(phone);
		member.setName(username);
		member.setDescription(description);
		member.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		memberDao.update(member);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	@RequestMapping(value = "/joinParty")
	public ModelAndView joinParty(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="partyId") Integer partyId,
			ModelMap model){
		Party party=partyDao.get(partyId);
		Visitor visitor=this.session.getSessionVisitor(request);
		boolean flag=false;
		if(party!=null){
			String []ids=party.getJoinMemberIds().split(",");
			if(ids.length>0){
				for(int i=0;i<ids.length;i++){
				    if(ids[i]!=""&&!StringUtils.isEmpty(ids[i])){
				    	if(Integer.valueOf(ids[i])==visitor.getUserid()||ids[i].equals(visitor.getUserid().toString())){
							  flag=true;
							  break;
						  }
				    }
				}
			}
			if(!flag){
				String joinIds=party.getJoinMemberIds();
				if(joinIds.endsWith(","))
					joinIds=joinIds+visitor.getUserid();
				else
					joinIds=joinIds+","+visitor.getUserid();
				party.setJoinMemberIds(joinIds);
				partyDao.update(party);
				AcountInfo a=memberMgr.getAcountInfoByMemberId(visitor.getUserid());
				int sum=0;
				if(a.getPartyJoinSum()!=null)
					sum=a.getPartyCreateSum()+1;
				memberDao.modifyJoinPartySum(visitor.getUserid(), sum);
				sum=0;
				if(a.getPoints()!=null)
					sum=a.getPoints()+5;
				memberDao.modifyJoinPartySum(visitor.getUserid(), sum);
			}
		}
		return this.buildSuccessByRedirectAndParam("/web/partyDetail", model, "partyId", partyId);
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
