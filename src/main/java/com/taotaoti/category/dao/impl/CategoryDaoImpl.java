package com.taotaoti.category.dao.impl;

import org.springframework.stereotype.Repository;

import com.taotaoti.category.bo.Category;
import com.taotaoti.category.dao.CategoryDao;
import com.taotaoti.common.dao.AbstractDao;

@Repository
public class CategoryDaoImpl extends AbstractDao<Integer, Category>
		implements CategoryDao {
}
