package com.taotaoti.good.vo;

import java.sql.Timestamp;
import java.util.List;

import com.taotaoti.cache.AppCache;
import com.taotaoti.good.bo.Good;

public class GoodView{
	private Integer goodId;
	private Integer categoryId;
	private String category;
	private String name;
	private String title ;
	private String description;
	private Timestamp createTime ;
	private Timestamp updateTime ;
	
	private Integer clickSum;
	private String logo ;
	private Integer statu;
	private Integer memberId;
	private double price;
	private String level;
	
	public GoodView() {
	}
	
	
	public GoodView(Integer goodId, Integer categoryId, String category,
			String name, String title, String description,
			Timestamp createTime, Timestamp updateTime, Integer clickSum,
			String logo, Integer statu, Integer memberId, double price,
			String level) {
		super();
		this.goodId = goodId;
		this.categoryId = categoryId;
		this.category = category;
		this.name = name;
		this.title = title;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.clickSum = clickSum;
		this.logo = logo;
		this.statu = statu;
		this.memberId = memberId;
		this.price = price;
		this.level = level;
	}
	
	public static GoodView toGoodView(Good good,String category,double price,String level){
		GoodView goodView=new GoodView(good.getGoodId(), good.getCategoryId(), category, good.getName(), good.getTitle(), good.getDescription(), good.getCreateTime(), good.getUpdateTime(), good.getClickSum(), good.getLogo(),good.getStatu(),good.getMemberId(), price, level);
		return goodView;
	}
	

	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getClickSum() {
		return clickSum;
	}
	public void setClickSum(Integer clickSum) {
		this.clickSum = clickSum;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}


	
	
	
	
}
