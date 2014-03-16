package com.taotaoti.category.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * CategoryVo
 *
 */
public class CategoryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5263014665358324876L;

	private List<SimpleTreeVo<Integer>> categorys;
	
	private List<SimpleTreeVo<Integer>> selectedCategorys;
	
	public CategoryVo() {
		this.categorys = new ArrayList<SimpleTreeVo<Integer>>();
		this.selectedCategorys = new ArrayList<SimpleTreeVo<Integer>>();
	}
	
	/**
	 * @return the pageCategorys
	 */
	public List<SimpleTreeVo<Integer>> getCategorys() {
		return categorys;
	}



	/**
	 * @return the selectedPageCategorys
	 */
	public List<SimpleTreeVo<Integer>> getSelectedCategorys() {
		return selectedCategorys;
	}



	public void addCategorys(SimpleTreeVo<Integer> category){
		categorys.add(category);
	}

	public void addSelectedCategorys(SimpleTreeVo<Integer> selectedCategory){
		selectedCategorys.add(selectedCategory);
	}
}
