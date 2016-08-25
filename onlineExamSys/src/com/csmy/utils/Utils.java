package com.csmy.utils;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.csmy.bean.Teacher;
import com.csmy.bean.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {
	static {
		// 在封装之前 注册转换器
		ConvertUtils.register(new DateTimeConverter(), java.util.Date.class);
	}
	public final static String CURRENT_USER_KEY="ONLINE_EXAM_CURRENT_USER_KEY";
	public static User getCurrentUser(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute(CURRENT_USER_KEY);
		if(user==null){
			user = new Teacher();
			user.setId(1);
			user.setName("刘勇");
			user.setDeptId(1);
			user.setRoleId(1);
		}
		return user;
	}
	
	public static void setCurrentUser(HttpServletRequest request,User user){
		request.getSession().setAttribute(CURRENT_USER_KEY,user);
	}
	
	
	
	/**
	 * 请求信息封装到对象
	 *
	 * @param request
	 *            请求信息
	 * @param clazz
	 *            封装对象
	 */
	@SuppressWarnings("unchecked")
	public static <E> E formToBean(HttpServletRequest request, Class<E> clazz) {		
		E obj = null;
		try {
			obj = clazz.newInstance();
			Map<String, String[]> parameterMap = request.getParameterMap();
			BeanUtils.populate(obj, parameterMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
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
