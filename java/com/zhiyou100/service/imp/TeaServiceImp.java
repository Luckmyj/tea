package com.zhiyou100.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.dao.TeaDao;
import com.zhiyou100.model.TeaMessage;
import com.zhiyou100.service.TeaService;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ViewVo;

@Service
public class TeaServiceImp implements TeaService {

	@Autowired
	private TeaDao dao;
	
	private static final int count = 5;
	
	public boolean saveTea(TeaMessage teaMessage) {
		
		// 设置评级的结果
		teaMessage.setGradeValue(Integer.parseInt(getGrading(getGradingScore(teaMessage)).substring(0,1)));
		teaMessage.setGrading(getGrading(getGradingScore(teaMessage)).substring(1));
		if (dao.saveTea(teaMessage)) {
			
			return true;
		}
		return false;
	}

	public PageInfo<TeaMessage> listTeaByPage(ViewVo viewVo) {
		
		int allRecord = dao.getRecordCount();
		
		int allPageCount = (allRecord + count - 1) / count;
		
		int beginNum = (viewVo.getPageIndex() - 1) * count;
		
		viewVo.setBeginNum(beginNum);
		
		viewVo.setCount(count);
		
		PageInfo<TeaMessage> pageInfo = new PageInfo<TeaMessage>(allPageCount, dao.listTeaByPage(viewVo));
		
		return pageInfo;
	}

	
	
	public List<Double> getGradingScore(TeaMessage teaMessage) {
		
		double[] array1 = {1,0.9,0.9,0.9,1,1,0.9};
		double[] array2 = {0.9,0.8,0.9,0.9,0.9,0.9,0.8};
		double[] array3 = {0.8,0.7,0.9,0.8,0.8,0.7,0.7};
		double[] array4 = {0.6,0.5,0.7,0.6,0.7,0.7,0.6};
		double[] array5 = {0.5,0.4,0.5,0.5,0.6,0.6,0.4};
		double[] array6 = {0.4,0.3,0.5,0.4,0.5,0.5,0.4};
		double[] array7 = {0.3,0.2,0.5,0.2,0.3,0.3,0.2};
		
		// 存算术的结果
		List<Double> list1 = new ArrayList<Double>();
//		// 存几何的结果
//		List<Double> list2 = new ArrayList<Double>();
		
		// 茶叶每个等级的评分
		List<double[]> list = new ArrayList<double[]>();
		list.add(array1);
		list.add(array2);
		list.add(array3);
		list.add(array4);
		list.add(array5);
		list.add(array6);
		list.add(array7);
		
		double[] array = {teaMessage.getShape(),teaMessage.getColour(),teaMessage.getNeatness(),teaMessage.getFragrance(),teaMessage.getLiquorColor(),teaMessage.getTaste(),teaMessage.getInfusedLeaf()};
		
		for (int i = 0; i < array7.length; i++) {
			
			list1.add(geometry(array, list.get(i)));
		}
		
		return list1;
	}
	
	/**
	 * 算术
	 */
	public static double geometry(double[] array1,double[] array2) {
		
		double num1 = 0;
		double num2 = 0;
		
		double[] array3 = new double[7];
		for (int i = 0; i < array2.length; i++) {
			if (array1[i] < array2[i]) {
				array3[i] = array1[i];
			}else {
				array3[i] = array2[i];
			}
			num1 += array3[i];
			num2 += array1[i] + array2[i]; 
		}
		
		double result = 2 * num1 / num2;
		
		return result;
	}

	public static String getGrading(List<Double> list) {


		int temp = 0;
		double max1 = list.get(0);
		for (int i = 1; i < list.size(); i++) {

			max1 = max1 > list.get(i) ? max1 : list.get(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			if (max1 == list.get(i)) {
				temp = i;
				break;
			}
		}
		
		String grade = "";
		switch (temp) {
		case 0:
			grade = "1特一级";
			break;
		case 1:
			grade = "2特二级";
			break;
		case 2:
			grade = "3特三级";
			break;
		case 3:
			grade = "4一级";
			break;
		case 4:
			grade = "5二级";
			break;
		case 5:
			grade = "6三级";
			break;
		case 6:
			grade = "7四级";
			break;

		default:
			break;
		}
		return grade;
	}

	public List<Integer> getGradeCount() {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(dao.getCountByGrading("特一级"));
		list.add(dao.getCountByGrading("特二级"));
		list.add(dao.getCountByGrading("特三级"));
		list.add(dao.getCountByGrading("一级"));
		list.add(dao.getCountByGrading("二级"));
		list.add(dao.getCountByGrading("三级"));
		list.add(dao.getCountByGrading("四级"));
		
		return list;
	}
}
