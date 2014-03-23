package com.taotaoti.good.error;

/**
 * 
 * 创意操作错误信息
 *
 * @version 2013-5-3 下午10:43:17
 */
public enum GoodError {
	CREATIVE_TYPE_INVALID(2000, "Creative type is invalid", "创意类型错误"),
	UNAUTHORIZE_TO_MANAGE_ADVERTISER(2001, "Unauthorize to the specified advertiser", "对操作客户无权限"),
	INVALID_OR_DUPLICATE_ORI_CREATIVE_ID(2002, "Invalid or duplicate creative id", "非法或者重复的创意ID"),
	CREATIVE_TRADE_ID_INVALID(2003, "Invalid trade id", "非法创意行业"),
	CREATIVE_HEIGHT_WIDTH_INVALID(2004, "Invalid height width", "非法创意高宽"),
	MONITOR_URL_NUM_EXCEED(2005, "Monitor url num exceed limit", "展现监测链接数量超限"),
	ADMAKER_FLASH_FILE_NOT_SUPPORTED(2036,"Creative flash file made by admaker is not temporarily supported","系统暂时不支持上传Admaker制作的flash物料"),
	;
	
	private int code = 0;
	private String message = null;
	private String resourceMessage = null;

	private GoodError(int code, String message, String resourceMessage) {
		this.code = code;
		this.message = message;
		this.resourceMessage = resourceMessage;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public String getResourceMessage() {
		return resourceMessage;
	}

	
}
