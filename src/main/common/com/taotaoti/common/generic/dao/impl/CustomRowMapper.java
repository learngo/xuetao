package com.taotaoti.common.generic.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.RowMapper;

public class CustomRowMapper<T>  implements RowMapper<T>{

	private Class<T> entityClass ;
	@Override
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		 
		try {
			return this.sqlColumnToDTO(rs, entityClass);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null ;
	}
	public CustomRowMapper(){
		//Type[] types = ClassUtils.getGenericTypes(getClass());
		//entityClass =;
	} ;
	public CustomRowMapper(Class<T> voClass)
	{
		entityClass = voClass;
	}
	
	public T sqlColumnToDTO(ResultSet rs, Class<T> entityClass) throws SQLException, InstantiationException, IllegalAccessException   {  
        ResultSetMetaData rsmd = rs.getMetaData();   
        int columnsCount = rsmd.getColumnCount();   
        String[] columnNames = new String[columnsCount];   
        for (int i = 0; i < columnsCount; i++) {   
            columnNames[i] = rsmd.getColumnLabel(i + 1);   
        }  
        T entity = entityClass.newInstance();
        for (String columnName:columnNames)
		{   
        	try {
				BeanUtils.setProperty(entity,columnName,rs.getObject(columnName));
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue ;
			}
		}
        return entity ;   
    }  
}
