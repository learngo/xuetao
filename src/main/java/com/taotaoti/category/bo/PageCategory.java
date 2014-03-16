///*******************************************************************************
// * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
// * Filename:    PageCategory.java
// * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
// * Create-Date: 2013-5-3 下午4:49:41
// *******************************************************************************/
//package com.baidu.one.adview.bo;
//
//import com.baidu.one.adview.dao.AdviewColumns.PageCategoryColumns;
//import com.baidu.ub.common.generic.annotation.Column;
//import com.baidu.ub.common.generic.annotation.Table;
//import com.baidu.ub.common.generic.bo.BaseObject;
//
///**
// * 页面分类字典表
// *
// * @author <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
// * @version 2013-5-3 下午4:49:41
// */
//@Table(db = "one_dict", name = "page_category", keyColumn = PageCategoryColumns.PAGE_CATEGORY_ID)
//public class PageCategory extends BaseObject<Integer> implements Comparable<PageCategory>{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -5565818167183342666L;
//
//	/**
//	 * 页面分类项名字
//	 */
//	@Column(maybeModified=false, value=PageCategoryColumns.NAME)
//	private String name;
//	
//	/**
//	 * 父节点的ID，无父亲id为0
//	 */
//	@Column(maybeModified=false, value=PageCategoryColumns.PARENTID)
//	private int parentid;
//	
//	/**
//	 * 节点排序的ID
//	 */
//	@Column(maybeModified=false, value=PageCategoryColumns.ORDERID)
//	private int orderid;
//
//	/**
//	 * @return the name
//	 */
//	public String getName() {
//		return name;
//	}
//
//	/**
//	 * @param name the name to set
//	 */
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	/**
//	 * @return the parentid
//	 */
//	public int getParentid() {
//		return parentid;
//	}
//
//	/**
//	 * @param parentid the parentid to set
//	 */
//	public void setParentid(int parentid) {
//		this.parentid = parentid;
//	}
//
//	/**
//	 * @return the orderid
//	 */
//	public int getOrderid() {
//		return orderid;
//	}
//
//	/**
//	 * @param orderid the orderid to set
//	 */
//	public void setOrderid(int orderid) {
//		this.orderid = orderid;
//	}
//
//	/**
//	 * @return the serialversionuid
//	 */
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	@Override
//	public int compareTo(PageCategory o) {
//		if(o == null ){
//			return 1;
//		}
//		return orderid - o.getOrderid();
//	}
//}
