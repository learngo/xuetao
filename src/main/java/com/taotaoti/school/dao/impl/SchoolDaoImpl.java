package com.taotaoti.school.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.school.bo.School;
import com.taotaoti.school.dao.SchoolDao;

@Repository
public class SchoolDaoImpl extends AbstractDao<Integer, School> implements SchoolDao{
	
	 protected final static Log LOG = LogFactory.getLog(SchoolDaoImpl.class);

	@Override
	public School createSchool(School school) {
		// TODO Auto-generated method stub
		return this.create(school);
	}

	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return this.counts();
	}
	
}
