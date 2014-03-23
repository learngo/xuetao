package com.taotaoti.good.validation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.taotaoti.cache.AppCache;
import com.taotaoti.category.bo.Category;
import com.taotaoti.common.dto.ErrorDTO;
import com.taotaoti.common.log.AopLogFactory;
import com.taotaoti.good.bo.GoodColumns;
import com.taotaoti.good.error.GoodError;
import com.taotaoti.good.vo.GoodView;


/**
 * 
 * 创意校验
 *
 */
@Component
public class GoodValidator {

	private final static Logger LOG = AopLogFactory.getLogger(GoodValidator.class);
	
	@Resource
	private AppCache appCache;
	
	
	public static boolean isCheckHasAuth2ManageOriAdvertiserId = true;
	
	/**
	 * 
	 * 验证添加创意是否合法
	 * By Zhang Xu 2013-5-4 上午11:09:54
	 *
	 * @param creative 创意VO
	 * @param index 创意在前端传递过来的下标
	 * @param errors 保存错误的list
	 * @param oriCreativeIdList db中已存在的oriCreativeId列表
	 * @param oriCreativeIdNonDupSet 本次操作前端传递过来的oriCreativeId集合
	 * @param oriAdvertiserId2AdvertiserIdMap DSP自定义广告主到系统内广告主ID的映射集合
	 * @return
	 */
	public boolean isValidAdd(GoodView goodView, int index, List<ErrorDTO> errors, Set<Long> oriCreativeIdNonDupSet, Map<Long, Integer> oriAdvertiserId2AdvertiserIdMap) {

//		//验证创意类型合法
//		if (!isTypeValid(creative.getType())) {
//			errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.CREATIVE_TYPE_INVALID.getCode(), CreativeError.CREATIVE_TYPE_INVALID.getMessage(), CreativeError.CREATIVE_TYPE_INVALID.getResourceMessage()));
//			return false;
//		}
//
//		//验证DSP有权限操作客户
//		if (!hasAuth2ManageOriAdvertiserId(creative.getDspId(), oriAdvertiserId2AdvertiserIdMap.get(creative.getOriAdvertiserId()))) {
//			errors.add(new ErrorDTO(index, CreativeField.advertiserId, CreativeError.UNAUTHORIZE_TO_MANAGE_ADVERTISER.getCode(), CreativeError.UNAUTHORIZE_TO_MANAGE_ADVERTISER.getMessage(), CreativeError.UNAUTHORIZE_TO_MANAGE_ADVERTISER.getResourceMessage()));
//			return false;
//		}
//
//		//验证DSP提交的创意ID不重复且大于0
//		if (!isInvalidOrDuplicateOriCreativeId(oriCreativeIdNonDupSet, creative.getOriCreativeId())) {
//			errors.add(new ErrorDTO(index, CreativeField.creativeId, CreativeError.INVALID_OR_DUPLICATE_ORI_CREATIVE_ID.getCode(), CreativeError.INVALID_OR_DUPLICATE_ORI_CREATIVE_ID.getMessage(), CreativeError.INVALID_OR_DUPLICATE_ORI_CREATIVE_ID.getResourceMessage()));
//			return false;
//		}
//
//		//验证行业ID在合法集合内
//		if (!isTradeIdValid(creative.getOriCreativeTradeId())) {
//			errors.add(new ErrorDTO(index, CreativeField.oriCreativeTradeId, CreativeError.CREATIVE_TRADE_ID_INVALID.getCode(), CreativeError.CREATIVE_TRADE_ID_INVALID.getMessage(), CreativeError.CREATIVE_TRADE_ID_INVALID.getResourceMessage()));
//			return false;
//		}
//
//		//验证创意高宽
//		if (!isHeightWidthValid(creative.getHeight(), creative.getWidth())) {
//			errors.add(new ErrorDTO(index, CreativeField.height, CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getCode(), CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getMessage(), CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getResourceMessage()));
//			return false;
//		}
//
//		//验证展现监测连接数量以及基本URL规则
//		if (!isMonitorUrlsValid(creative.getDspId(),creative.getLandingPage(),creative.getMonitorUrls(), index, errors)) {
//			return false;
//		}
//
//		//验证点击链接、目标URL基本URL规则
//		if (!isValidUrl(creative.getTargetUrl(), CreativeField.targetUrl, index, 
//				errors, CreativeConstant.TARGET_MONITOR_URL_MAX_LENGTH, true)) {
//			return false;
//		}
//		if (!isValidUrl(creative.getLandingPage(), CreativeField.landingPage, index,
//				errors, CreativeConstant.CREATIVE_URL_MAX_LENGTH, true)) {
//			return false;
//		}
//
//		//获取图片并验证
//		if (!isValidCreativeBinaryData(creative, index, errors, false)) {
//			return false;
//		}
//		
//		//添加创意时判断是否是和法的合同号码
//		if(! isAgreementNoValid(creative.getFrameAgreementNo(), creative.getDspId(), creative.getOriAdvertiserId(), CreativeField.frameAgreementNo, index, errors)){
//			return false;
//		}

		return true;
	}
	
	/**
	 * 
	 * 验证修改创意是否合法
	 * By Zhang Xu 2013-5-4 上午11:09:54
	 *
	 * @param creative 创意VO
	 * @param index 创意在前端传递过来的下标
	 * @param errors 保存错误的list
	 * @param oriCreativeIdList db中已存在的oriCreativeId列表
	 * @param oriCreativeIdNonDupSet 本次操作前端传递过来的oriCreativeId集合
	 * @return
	 */
	public boolean isValidUpdate(GoodView goodView, Set<Long> dbOriCreativeIdSet, int index, List<ErrorDTO> errors) {

//		boolean isUpdateImageOrFlash = false;
//		if (creative.getBinaryData() != null || !StringUtils.isEmpty(creative.getCreativeUrl())) {
//			isUpdateImageOrFlash = true;
//		}
//		
		if (goodView.getGoodId() < 1) {
			errors.add(new ErrorDTO(index, GoodColumns.categoryId, GoodError.ADMAKER_FLASH_FILE_NOT_SUPPORTED.getCode(), GoodError.ADMAKER_FLASH_FILE_NOT_SUPPORTED.getMessage(), GoodError.ADMAKER_FLASH_FILE_NOT_SUPPORTED.getResourceMessage()));
			return false;
		}
//		
//		//验证创意类型合法
//		if (creative.getType() == CreativeConstant.CREATIVE_DEFAULT_VALUE_1) {
//			if (isUpdateImageOrFlash) {
//				errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.TYPE_EMTPY_WHEN_IMAGE_OR_FLASH_UPDATE.getCode(), CreativeError.TYPE_EMTPY_WHEN_IMAGE_OR_FLASH_UPDATE.getMessage(), CreativeError.TYPE_EMTPY_WHEN_IMAGE_OR_FLASH_UPDATE.getResourceMessage()));
//				return false;
//			}
//		} else {
//			if (!isUpdateImageOrFlash) {
//				errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.TYPE_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getCode(), CreativeError.TYPE_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getMessage(), CreativeError.TYPE_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getResourceMessage()));
//				return false;
//			}
//			if (!isTypeValid(creative.getType())) {
//				errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.CREATIVE_TYPE_INVALID.getCode(), CreativeError.CREATIVE_TYPE_INVALID.getMessage(), CreativeError.CREATIVE_TYPE_INVALID.getResourceMessage()));
//				return false;
//			}
//		}
//
//		//验证行业ID在合法集合内
//		if (creative.getOriCreativeTradeId() != CreativeConstant.CREATIVE_DEFAULT_VALUE_0) {
//			if (!isTradeIdValid(creative.getOriCreativeTradeId())) {
//				errors.add(new ErrorDTO(index, CreativeField.oriCreativeTradeId, CreativeError.CREATIVE_TRADE_ID_INVALID.getCode(), CreativeError.CREATIVE_TRADE_ID_INVALID.getMessage(), CreativeError.CREATIVE_TRADE_ID_INVALID.getResourceMessage()));
//				return false;
//			}
//		}
//
//		//验证创意高宽
//		if (creative.getHeight() < 1 || creative.getWidth() < 1) {
//			if (isUpdateImageOrFlash) {
//				errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.HEIGHT_WIDTH_EMPTY_WHEN_IMAGE_OR_FLASH_UPDATE.getCode(), CreativeError.HEIGHT_WIDTH_EMPTY_WHEN_IMAGE_OR_FLASH_UPDATE.getMessage(), CreativeError.HEIGHT_WIDTH_EMPTY_WHEN_IMAGE_OR_FLASH_UPDATE.getResourceMessage()));
//				return false;
//			}
//		} else {
//			if (!isUpdateImageOrFlash) {
//				errors.add(new ErrorDTO(index, CreativeField.type, CreativeError.HEIGHT_WIDTH_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getCode(), CreativeError.HEIGHT_WIDTH_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getMessage(), CreativeError.HEIGHT_WIDTH_CANBE_UPDATED_ONLYIF_IMAGE_OR_FLASH_UPDATE.getResourceMessage()));
//				return false;
//			}
//			if (!isHeightWidthValid(creative.getHeight(), creative.getWidth())) {
//				errors.add(new ErrorDTO(index, CreativeField.height, CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getCode(), CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getMessage(), CreativeError.CREATIVE_HEIGHT_WIDTH_INVALID.getResourceMessage()));
//				return false;
//			}
//		}
//
//		//验证展现监测连接数量以及基本URL规则
//		if (!StringUtils.isEmpty(creative.getMonitorUrls())) {
//			if (!isMonitorUrlsValid(creative.getDspId(),creative.getLandingPage(),creative.getMonitorUrls(), index, errors)) {
//				return false;
//			}
//		}
//				
//		//验证点击链接、目标URL基本URL规则
//		if (creative.getTargetUrl() != null) {
//			if (!isValidUrl(creative.getTargetUrl(), CreativeField.targetUrl, index,
//					errors, CreativeConstant.TARGET_MONITOR_URL_MAX_LENGTH, true)) {
//				return false;
//			}
//		}
//		if (creative.getLandingPage() != null) {
//			if (!isValidUrl(creative.getLandingPage(), CreativeField.landingPage, index,
//					errors, CreativeConstant.CREATIVE_URL_MAX_LENGTH, true)) {
//				return false;
//			}
//		}
//
//		//获取图片并验证
//		if (isUpdateImageOrFlash) {
//			if (!isValidCreativeBinaryData(creative, index, errors, false)) {
//				return false;
//			}
//		}
//		
//		//调用验证合同号的接口，如果验证失败，则返回false 
//		if(! isAgreementNoValid(creative.getFrameAgreementNo(), creative.getDspId(), creative.getOriAdvertiserId(),  CreativeField.frameAgreementNo, index, errors)){
//			return false;
//		}
		
		return true;
	}

	/**
	 * 
	 * 验证dsp是否有权限操作广告主
	 *
	 * @param dspId
	 * @param avertiserId ONE自己的广告主ID
	 * @return
	 */
	protected boolean hasAuth2ManageOriAdvertiserId(int dspId, Integer advertiserId) {
		if (isCheckHasAuth2ManageOriAdvertiserId) {
			if (advertiserId == null) {
				return false;
			}

			/* 由于userMgr.getAdvertiserByDspId(dspId);已经做了权限，所以这里不必要再添加逻辑。
			if (!userMgr.hasDataPrivilege(null, dspId, advertiserId)) {
				LOG.info("dspId=" + dspId + " not auth of oriAdvertiserId=" + advertiserId);
				return false;
			}
			*/
			
		}
		return true;
	}

	protected boolean isCategoryIdValid(int categoryId) {
	    Category category= appCache.getCategoryCache().get(categoryId);
		if(category!=null)
			return true;
		return false;
	}

	

}
