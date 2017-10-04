package com.zhiyou100.service;

import com.zhiyou100.model.User;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ViewVo;

public interface UserService {
	
	boolean saveUser(User user);
	
	PageInfo<User> listUser(ViewVo viewVo);
}
