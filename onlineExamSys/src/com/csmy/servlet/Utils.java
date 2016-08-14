package com.csmy.servlet;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.csmy.bean.Teacher;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	
	private final static String CURRENT_USER_KEY="ONLINE_EXAM_CURRENT_USER_KEY";
	public static Teacher getCurrentUser(HttpServletRequest request){
		Teacher user = (Teacher) request.getSession().getAttribute(CURRENT_USER_KEY);
		if(user==null){
			user = new Teacher();
			user.setId(1);
			user.setName("刘勇");
			user.setDeptId(1);
			user.setRoleId(1);
		}
		return user;
	}
	
	public static void setCurrentUser(HttpServletRequest request,Teacher user){
		request.getSession().setAttribute(CURRENT_USER_KEY,user);
	}
	
	public static <T> T formToBean(HttpServletRequest request, Class<T> beanClass) {  
        try {  
            // 创建封装数据的bean  
            T bean = beanClass.newInstance();  
            Map map = request.getParameterMap();  
            BeanUtils.populate(bean, map);  
            return bean;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
	
	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithModifiers(Modifier.PUBLIC)
				.create();
		String json = gson.toJson(obj);		
		return json;
	}
	
	public static <T> String listToJson(List<T> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (T o : list) {
			if (sb.length() > 1)
				sb.append(",");
			sb.append(o);
		}
		sb.append("]");
		return sb.toString();
	}

	public static <T> T fromJson(String str, Class<T> c) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithModifiers(Modifier.PUBLIC)
				.create();
		return gson.fromJson(str, c);
	}

	public static <T> List<T> fromJson(String str, Type type) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").excludeFieldsWithModifiers(Modifier.PUBLIC)
				.create();
		return gson.fromJson(str, type);
	}
	
	public static int GetPageSize(String rows)
    {
        try
        {
            return Integer.parseInt(rows);
        }
        catch(Exception ex)
        {
            return 10;
        }
    }


    public static String GetOrder(String order)
    {
    	return order== null ? "asc":order;
        
    }


    public static String GetSort(String sort)
    {
    	return sort == null ? "id" : sort;
    }

    public static int GetPageIndex(String  page)
    {
        try
        {
            return Integer.parseInt(page);
        }
        catch(Exception ex)
        {
            return 1;
        }
    }
}
