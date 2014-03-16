
package com.taotaoti.category.dao;

import java.util.List;

import com.taotaoti.category.bo.Category;
import com.taotaoti.common.generic.dao.BaseDao;

public interface CategoryDao extends BaseDao<Integer, Category> {
	List<Category> findAll();
}