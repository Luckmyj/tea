package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.TeaMessage;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ViewVo;

public interface TeaService {
	
	/**
	 * 保存使用过该系统评级的记录
	 * @param teaMessage
	 * @return
	 */
	boolean saveTea(TeaMessage teaMessage);
	
	/**
	 * 分页展示使用该系统评级的茶叶
	 * @param pageIndex
	 * @return
	 */
	PageInfo<TeaMessage> listTeaByPage(ViewVo viewVo);
	
	/**
	 * 评级茶叶 与 茶叶级别的相似度
	 * @param teaMessage
	 * @return
	 */
	List<Double> getGradingScore(TeaMessage teaMessage);
	
	/**
	 * 获得每个等级的数量
	 * @return
	 */
	List<Integer> getGradeCount();
	
//	/**
//	 * 评级结果的等级
//	 * @param list
//	 * @return
//	 */
//	String getGrading(List<Double> list);
}
