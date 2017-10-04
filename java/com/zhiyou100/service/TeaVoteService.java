package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.TeaVote;

public interface TeaVoteService {
	
	
	boolean updateTeaVote(Integer id);
	
	
	List<TeaVote> listTeaVote();
	
	List<TeaVote> listTeaVoteDesc();
}
