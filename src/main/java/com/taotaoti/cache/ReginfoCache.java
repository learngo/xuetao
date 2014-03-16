package com.taotaoti.cache;

import org.springframework.stereotype.Component;

import com.taotaoti.category.bo.Reginfo;

/**
 * ReginfoCache
 *
 * @version 2013-5-15 下午4:04:41
 */
@Component
public class ReginfoCache extends AbstractTreeCache<Integer, Reginfo> {

	@Override
	public Integer getId(Reginfo t) {
		if(t == null){
			return null;
		}
		int id = t.getSecondRegid();
		if(id == 0){
			id = t.getFirstRegid();
		}
		return id;
	}

	@Override
	public Integer getParentId(Reginfo t) {
		if(t == null){
			return null;
		}
		int id = t.getSecondRegid();
		if(id == 0){
			return null;
		}
		return t.getFirstRegid();
	}
}
