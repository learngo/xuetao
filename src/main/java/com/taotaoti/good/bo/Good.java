package com.taotaoti.good.bo;

import java.sql.Timestamp;

import org.junit.Ignore;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "good", keyColumn = GoodColumns.goodId)
public class Good extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=GoodColumns.goodId)
	private Integer goodId;
	@Column(value=GoodColumns.categoryId)
	private Integer categoryId;
	@Column(value=GoodColumns.name)
	private String name;
	@Column(value=GoodColumns.title)
	private String title ;
	@Column(value=GoodColumns.description)
	private String description;
	@Column(value=GoodColumns.createTime)
	private Timestamp createTime ;
	@Column(value=GoodColumns.updateTime)
	private Timestamp updateTime ;
	
	@Column(value=GoodColumns.clickSum)
	private Integer clickSum;
	@Column(value=GoodColumns.logo)
	private String logo ;
	@Column(value=GoodColumns.statu)
	private Integer statu;
	@Column(value=GoodColumns.memberId)
	private Integer memberId;
	@Column(value="ignore")
	private String memberName;
	@Column(value="ignore")
	private String memberPhoto;
	
	@Column(value=GoodColumns.price)
	private Integer price;
	@Column(value=GoodColumns.level)
	private Integer level;
	
	@Column(value=GoodColumns.buyerName)
	private String buyerName;
	
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Good(){
		
	}
	public Good(Integer goodId, Integer categoryId, String name, String title,
			String description, Timestamp createTime, Timestamp updateTime,
			Integer clickSum, String logo, Integer statu, Integer memberId,
			Integer price, Integer level) {
		super();
		this.goodId = goodId;
		this.categoryId = categoryId;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhoto() {
		return memberPhoto;
	}
	public void setMemberPhoto(String memberPhoto) {
		this.memberPhoto = memberPhoto;
	}
	
	
	
	
	
}
