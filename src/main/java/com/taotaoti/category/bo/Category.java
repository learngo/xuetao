package com.taotaoti.category.bo;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "category", keyColumn = CategoryColumns.categoryId)
public class Category extends BaseObject<Integer> implements Comparable<Category>{
	private static final long serialVersionUID = 1L;
	@Column(value=CategoryColumns.name)
	private String name;
	@Column(value=CategoryColumns.parentId)
	private int parentId;
	@Column(value=CategoryColumns.orderId)
	private int orderId;
	@Column(value=CategoryColumns.remark)
	private String remark;
	@Column(value=CategoryColumns.statu)
	private int statu;

	public Category() {
	}


	public Category(String name, int parentId, String remark, int statu) {
		super();
		this.name = name;
		this.parentId = parentId;
		this.remark = remark;
		this.statu = statu;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public int getStatu() {
		return statu;
	}


	public void setStatu(int statu) {
		this.statu = statu;
	}


	@Override
	public int compareTo(Category o) {
		// TODO Auto-generated method stub
		if(o == null ){
			return 1;
		}
		return orderId - o.getOrderId();
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
