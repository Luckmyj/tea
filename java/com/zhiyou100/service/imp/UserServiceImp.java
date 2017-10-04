package com.zhiyou100.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.UserDao;
import com.zhiyou100.model.User;
import com.zhiyou100.service.UserService;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ViewVo;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao dao;
	
	private static final int count = 5;
	
	public boolean saveUser(User user) {
		
		if (dao.saveUser(user)) {
			return true;
		}
		return false;
	}

	public PageInfo<User> listUser(ViewVo viewVo) {
		
		int allRecord = dao.getRecordCount();
		
		int allPageCount = (allRecord + count - 1) / count;
		
		int beginNum = (viewVo.getPageIndex() - 1) * count;
		
		viewVo.setBeginNum(beginNum);
		
		viewVo.setCount(count);
		
		PageInfo<User> pageInfo = new PageInfo<User>(allPageCount, dao.listUser(viewVo));
		
		return pageInfo;
	}

}
