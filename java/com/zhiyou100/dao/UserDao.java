package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.User;
import com.zhiyou100.vo.ViewVo;

public interface UserDao {
	
	boolean saveUser(User user);
	
	List<User> listUser(ViewVo viewVo);
	
	int getRecordCount();
}
