package com.csmy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csmy.bean.User;
import com.csmy.service.RoleService;
import com.csmy.utils.Utils;

@WebFilter("*.do")
public class CodingFilter implements Filter {
	RoleService roleService = new RoleService();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		String url = request.getServletPath();
		User user = Utils.getCurrentUser(request);
		String action = request.getParameter("action");
		boolean isAuthorized = false;
		if("getuser".equals(action) || "login".equals(action) ||  "logout".equals(action)){
			isAuthorized = true;
		}else if(user==null){
			response.setContentType("text/html");
			response.sendRedirect("login.html");
			return;
		}else if ("listSysMenu".equals(action)) {
			isAuthorized = true;
		}else if(action!=null && action.length()>0){
			
			int s = url.lastIndexOf('/');
			int e = url.lastIndexOf("Servlet.do");
			String menu = url.substring(s+1, e);
			if("exam".equals(menu)){
				isAuthorized = true;
			}else{
				menu = menu + ".html";
				isAuthorized = roleService.isAuthorize(user.getRoleId(),menu, action);
			}
		}
		if(isAuthorized){
			response.setContentType("text/plain");
			chain.doFilter(request, response);
		}else{
			response.getWriter().println("{\"success\":false,\"msg\":\"无权访问\"}");
			response.getWriter().close();			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
