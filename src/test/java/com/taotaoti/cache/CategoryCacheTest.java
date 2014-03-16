package com.taotaoti.cache;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.category.bo.Category;
import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.ObjToStringUtil;

public class CategoryCacheTest extends BaseTestCase{
	
	@Resource
	private AppCache appCache;

	@Test
	public void testGJS() {
		ITreeCache<Integer, Category> rc = appCache.getCategoryCache();
		Map<Integer, List<Category>> parentId2Children = rc.getParentId2Children();
		System.out.println(ObjToStringUtil.objToString(rc));
		System.out.println(ObjToStringUtil.objToString(parentId2Children));
		for(Map.Entry<Integer, List<Category>> en : parentId2Children.entrySet()){
			Integer key = en.getKey();
			Category reginfo = rc.get(key);
			System.out.println("                    {\"id\":"+"\""+key+"\",\"name\":\""+reginfo.getName()+"\"");
			System.out.println("                    \t,\"children\":[");
			List<Category> value = en.getValue();
			for(Category re : value){
				System.out.println("                    \t\t{\"id\":"+"\""+re.getName()+"\",\"name\":\""+re.getParentId()+"\"},");
			}
			
			System.out.println("                    \t]");
			System.out.println("                    },");
		}
		
		System.out.println("=================================");
		List<Category> value = rc.getChildren(2);
		for(Category re : value){
			System.out.println("                    \t\t{\"id\":"+"\""+re.getName()+"\",\"name\":\""+re.getParentId()+"\"},");
		}
		List<Integer> ids= rc.getRootIds();
		for(Integer id:ids){
			List<Category> categories=rc.getChildren(id);
			
			
		}
		
		
	}

}
