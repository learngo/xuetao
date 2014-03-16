package com.taotaoti.cache;

import org.springframework.stereotype.Component;

import com.taotaoti.category.bo.Category;

/**
 * InterestCache
 *
 * @version 2013-7-22 上午12:37:13
 */
@Component
public class CategoryCache extends AbstractTreeCache<Integer, Category>{

	@Override
	public Integer getId(Category t) {
		if(t == null){
			return null;
		}
		
		return t.getId();
	}

	@Override
	public Integer getParentId(Category t) {
		if(t == null){
			return null;
		}
		
		Integer parentid = t.getParentId();
		if(parentid == 0){
			return null;
		}
		
		return parentid;
	}
}
