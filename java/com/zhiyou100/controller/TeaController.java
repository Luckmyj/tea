package com.zhiyou100.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.TeaMessage;
import com.zhiyou100.service.TeaService;
import com.zhiyou100.vo.PageInfo;
import com.zhiyou100.vo.ResponseVo;
import com.zhiyou100.vo.ViewVo;

@Controller
public class TeaController {
	
	@Autowired
	private TeaService service;
	
	@RequestMapping(path="/tea/grading", method=RequestMethod.POST)
	public @ResponseBody ResponseVo<Double> gradingSroce(@RequestBody TeaMessage teaMessage) {
		
		if (service.saveTea(teaMessage)) {
			List<Double> list = service.getGradingScore(teaMessage);
			return new ResponseVo<Double>(0, teaMessage.getGrading(), list);
		}else {
			return new ResponseVo<Double>(-1, "评级失败", null);
		}
	}
	
	@RequestMapping(path="/tea/statistics", method=RequestMethod.POST)
	public @ResponseBody PageInfo<TeaMessage> listRecord(@RequestBody ViewVo viewVo) {
		
//		return service.listTeaByPage(param.get("pageIndex"));
		return service.listTeaByPage(viewVo);
	}
	
	@RequestMapping(path="/tea/pie", method=RequestMethod.POST)
	public @ResponseBody List<Integer> getGradeCount() {
		
		return service.getGradeCount();
	}
}













