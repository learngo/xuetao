package com.taotaoti.notifiaction;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.common.utils.StringUtils;
import com.taotaoti.message.bo.Notification;
import com.taotaoti.message.constant.EvaluateConstant;
import com.taotaoti.message.dao.NotificationDao;
import com.taotaoti.message.service.EvaluateMgr;

public class NotificationDaoTest extends BaseTestCase {
	
	@Resource
	private NotificationDao notificationDao;
	@Resource
	private EvaluateMgr evaluateMgr;
	
	@Test
	public void testFindOne(){
		Notification notification=notificationDao.findOne(3);
		List<String> ids=StringUtils.splitToList(notification.getEvaluateIds(), "\\|");
		List<Integer> evaluateIds=new ArrayList<Integer>();
		for(int i=0;i<ids.size();i++){
			evaluateIds.add(Integer.valueOf(ids.get(i)));
			System.out.println(ids.get(i));
		}
	}
	@Test
	public void testf(){
		System.out.println(ObjToStringUtil.objToString(evaluateMgr.findEvaluate(EvaluateConstant.EVALUATE_PRODUCT_TYPE_PARTY, 5)));
	}
	
}
