package com.taotaoti.category.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SimpleTreeVo
 * 
 */
public class SimpleTreeVo<ID> implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8893163539965309373L;
	private ID id;
	private boolean isSelected;
	private String name;
	private ID parentId;
	private String parentName;
	private List<SimpleTreeVo<ID>> children;
	
	public SimpleTreeVo() {
		this.children = new ArrayList<SimpleTreeVo<ID>>();
	}

	/**
	 * @return the id
	 */
	public ID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ID id) {
		this.id = id;
	}
	/**
	 * @return the isSelected
	 */
	public boolean getIsSelected() {
		return isSelected;
	}
	/**
	 * @param isSelected the isSelected to set
	 */
	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the parentId
	 */
	public ID getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(ID parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * @return the children
	 */
	public List<SimpleTreeVo<ID>> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<SimpleTreeVo<ID>> children) {
		this.children = children;
	}
	
	public void addChild(SimpleTreeVo<ID> child) {
		this.children.add(child);
	}
	
	public static <ID> SimpleTreeVo<ID> getUnSelected(SimpleTreeVo<ID> vo){
		if(vo == null){
			return null;
		}
		
		if (vo.getIsSelected()) {
			return null;
		}
		SimpleTreeVo<ID> ret = new SimpleTreeVo<ID>();
		ret.setId(vo.getId());
		ret.setName(vo.getName());
		ret.setParentId(vo.getParentId());
		ret.setParentName(vo.getParentName());
		ret.setIsSelected(false);

		List<SimpleTreeVo<ID>> children = vo.getChildren();
		if(children != null){
			for (SimpleTreeVo<ID> child : children) {
				SimpleTreeVo<ID> selected = getUnSelected(child);
				if (selected != null) {
					ret.addChild(selected);
				}
			}
		}
		return ret;
	}
	
	public static <ID> SimpleTreeVo<ID> getSelected(SimpleTreeVo<ID> vo){
		if(vo == null){
			return null;
		}
		
		if (!isNeedNode(vo)) {
			return null;
		}
		SimpleTreeVo<ID> ret = new SimpleTreeVo<ID>();
		ret.setId(vo.getId());
		ret.setName(vo.getName());
		ret.setParentId(vo.getParentId());
		ret.setParentName(vo.getParentName());
		ret.setIsSelected(vo.getIsSelected());

		List<SimpleTreeVo<ID>> children = vo.getChildren();
		if(children != null){
			for (SimpleTreeVo<ID> child : children) {
				SimpleTreeVo<ID> selected = getSelected(child);
				if (selected != null) {
					ret.addChild(selected);
				}
			}
		}
		return ret;
	}
	
	public static <ID> boolean isNeedNode(SimpleTreeVo<ID> vo){
		if(vo.getIsSelected()){
			return true;
		}
		
		List<SimpleTreeVo<ID>> children = vo.getChildren();
		if(children != null){
			for(SimpleTreeVo<ID> child : children){
				boolean isneedNode = isNeedNode(child);
				if(isneedNode){
					return true;
				}
			}
		}
		
		return false;
	}
}
