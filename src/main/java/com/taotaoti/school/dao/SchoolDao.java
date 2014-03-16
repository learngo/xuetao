
package com.taotaoti.school.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.school.bo.School;

public interface SchoolDao extends BaseDao<Integer, School> {
	
	public List<School> findAll();
	
	public School createSchool(School school);

	public int counts();
}