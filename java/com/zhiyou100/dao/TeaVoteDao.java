package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.TeaVote;

public interface TeaVoteDao {
	
	
	boolean updateTeaVote(Integer id);
	
	List<TeaVote> listTeaVote();
	
	List<TeaVote> listTeaVoteDesc();
}
