package com.zhiyou100.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ResponseVo;
import com.zhiyou100.vo.ViewVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(path="/user/save", method=RequestMethod.POST)
	public @ResponseBody ResponseVo<User> saveUser(@RequestBody User user, HttpSession session) {
		
		if (service.saveUser(user)) {
			
			session.setAttribute("user", user);
			return new ResponseVo<User>(0, "验证成功", null);
		}else {
			return new ResponseVo<User>(-1, "验证失败", null);
		}
	}
	
	@RequestMapping(path="/user/list", method=RequestMethod.POST)
	public @ResponseBody PageInfo<User> listUser(@RequestBody ViewVo viewVo) {
		
		return service.listUser(viewVo);
	}
}











