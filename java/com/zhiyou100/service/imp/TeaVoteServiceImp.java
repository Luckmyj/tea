package com.zhiyou100.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.TeaVoteDao;
import com.zhiyou100.model.TeaVote;
import com.zhiyou100.service.TeaVoteService;

@Service
public class TeaVoteServiceImp implements TeaVoteService{
	
	@Autowired
	private TeaVoteDao dao;

	public boolean updateTeaVote(Integer id) {
		
		return dao.updateTeaVote(id);
	}

	public List<TeaVote> listTeaVote() {
		
		return dao.listTeaVote();
	}

	public List<TeaVote> listTeaVoteDesc() {
		
		return dao.listTeaVoteDesc();
	}
}
