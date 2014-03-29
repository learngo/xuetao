package com.taotaoti.good.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

@Table(db = "xuetao", name = "good_Pic", keyColumn = GoodColumns.GoodCommentColumns.goodCommentId)
public class GoodPic extends BaseObject<Integer>{
	private static final long serialVersionUID = 1L;
	@Column(value=GoodColumns.GoodPicColumns.goodPicId)
	private Integer goodPicId;
	@Column(value=GoodColumns.GoodPicColumns.goodId)
	private Integer goodId;
	@Column(value=GoodColumns.GoodPicColumns.path)
	private String path;
	@Column(value=GoodColumns.GoodPicColumns.statu)
	private Integer statu ;
	
	@Column(value=GoodColumns.GoodPicColumns.description)
	private String description ;
	
	@Column(value=GoodColumns.GoodPicColumns.title)
	private String title ;

	public GoodPic(){
		
	}
	
	
	public GoodPic(Integer goodPicId, Integer goodId, String path,
			Integer statu, String description, String title) {
		super();
		this.goodPicId = goodPicId;
		this.goodId = goodId;
		this.path = path;
		this.statu = statu;
		this.description = description;
		this.title = title;
	}

	public Integer getGoodPicId() {
		return goodPicId;
	}

	public void setGoodPicId(Integer goodPicId) {
		this.goodPicId = goodPicId;
	}

	public Integer getGoodId() {
		return goodId;
	}

	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
	
	
}
