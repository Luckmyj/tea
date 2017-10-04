package com.zhiyou100.dao;


import java.util.List;

import com.zhiyou100.model.TeaMessage;
import com.zhiyou100.vo.ViewVo;

public interface TeaDao {
	
	boolean saveTea(TeaMessage teaMessage);
	
	int getRecordCount();
	
	List<TeaMessage> listTeaByPage(ViewVo viewVo);
	
	int getCountByGrading(String grade);
//	
//	List<TeaMessage> listTeaByGradeDesc(int beginNum, int count);
//	
//	List<TeaMessage> listTeaByGradeAsc(int beginNum, int count);
//	
//	List<TeaMessage> listTeaByTimeDesc(int beginNum, int count);
//	
//	List<TeaMessage> listTeaByTimeAsc(int beginNum, int count);
}
