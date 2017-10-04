package com.zhiyou100.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhiyou100.model.TeaVote;
import com.zhiyou100.vo.ResponseVo;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Object user = session.getAttribute("user");
		
		if (user == null) {
			
			ResponseVo<TeaVote> responseVo = new ResponseVo<TeaVote>(-1000, "需要登录", null);
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			String json = objectMapper.writeValueAsString(responseVo);
			
			response.setContentType("application/json;charset=utf-8");
			
			response.getWriter().println(json);
			
			return false;
		}
		return true;
		
	}

}
