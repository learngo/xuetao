package com.taotaoti.category.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.taotaoti.cache.ITreeCache;
import com.taotaoti.category.bo.Category;


public class CategoryForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3132803539159781061L;

	private int isAllCategory;
	private CategoryVo list;
	
	public CategoryForm(int isAllCategory, List<Integer> categoryIds,final ITreeCache<Integer, Category> categoryCache){
		this.isAllCategory=isAllCategory;
		this.list = new CategoryVo();
		
		List<Integer> rootIds = categoryCache.getRootIds();
		
		if(rootIds != null){
			for(Integer rootId : rootIds){
				SimpleTreeVo<Integer> markedSimpleTreeVo = getMarkedSimpleTreeVo(rootId, categoryIds, categoryCache);
				SimpleTreeVo<Integer> selected = SimpleTreeVo.getSelected(markedSimpleTreeVo);
				if(selected != null){
					list.addSelectedCategorys(selected);
				}
				
				list.addCategorys(markedSimpleTreeVo);
			}
		}
	}
	
	public SimpleTreeVo<Integer> getMarkedSimpleTreeVo(Integer pid, List<Integer> categoryIds, ITreeCache<Integer, Category> categoryCache){
		SimpleTreeVo<Integer> ret = new SimpleTreeVo<Integer>();
		Category category = categoryCache.get(pid);
		ret.setId(category.getId());
		ret.setName(category.getName());
		
		Category parent = categoryCache.getParent(ret.getId());
		if(parent != null){
			ret.setParentId(parent.getId());
			ret.setParentName(parent.getName());
		}else{
			ret.setParentId(0);
			ret.setParentName(null);
		}
		
		if(categoryIds.contains(ret.getId())){
			ret.setIsSelected(true);
		}
		
		List<Category> children = categoryCache.getChildren(pid);
		if(children == null ){
			ret.setChildren(new ArrayList<SimpleTreeVo<Integer>>());
		}else{
			for(Category child : children){
				SimpleTreeVo<Integer> simpleTreeVo = getMarkedSimpleTreeVo(child.getId(),categoryIds, categoryCache);
				if(!simpleTreeVo.getIsSelected()){
					//只要其中一个子节点为false， 父节点就为false
					ret.setIsSelected(false);
				}
				ret.addChild(simpleTreeVo);
			}
		}
		
		return ret;
	}

	/**
	 * @return the isAllPageCategory
	 */
	public int getIsAllCategory() {
		return isAllCategory;
	}

	/**
	 * @return the list
	 */
	public CategoryVo getList() {
		return list;
	}
}
