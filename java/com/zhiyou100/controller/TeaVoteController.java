package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou100.model.TeaVote;
import com.zhiyou100.service.TeaVoteService;
import com.zhiyou100.vo.ResponseVo;

@Controller
public class TeaVoteController {
	
	@Autowired
	private TeaVoteService service;
	
//	@RequestMapping("/vote")
//	public String teaVote(Model model){
//		
//		List<TeaVote> list = service.listTeaVote();
//		
//		model.addAttribute("teaVote",list);
//		
//		return "vote.jsp";
//	}
	
	@RequestMapping(path="/tea/vote", method=RequestMethod.POST)
	public @ResponseBody List<TeaVote> teaVote() {
		
		return service.listTeaVote();
	}
	
	@RequestMapping(path="/tea/update", method=RequestMethod.POST)
	public @ResponseBody ResponseVo<TeaVote> updateVote(@RequestBody HashMap<String, Integer> param) {
		
		if (service.updateTeaVote(param.get("id"))) {
			return new ResponseVo<TeaVote>(0, "投票成功", null);
		}else {
			return new ResponseVo<TeaVote>(-1, "投票失敗", null);
		}
		
	}
	
	@RequestMapping(path="/tea/listDesc", method=RequestMethod.POST)
	public @ResponseBody List<TeaVote> listTeaDesc() {
		
		return service.listTeaVoteDesc();
	}
}













