package com.jhta.finalproject.jobcontroller;

import java.io.File;
import java.security.Principal;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhta.finalproject.jobvo.JobVo;
import com.jhta.finalproject.service.CareerService;
import com.jhta.finalproject.service.DutyService;
import com.jhta.finalproject.service.JobService;
import com.jhta.finalproject.service.MyJobService;
import com.jhta.finalproject.service.ZoneService;
import com.jhta.finalproject.vo.MemberVo;

@Controller
public class JobDelete {
	@Autowired private ServletContext sc;
	@Autowired private JobService Jservice;
	@Autowired private MyJobService MJservice;
	@Autowired private ZoneService Zservice;
	@Autowired private DutyService Dservice;
	@Autowired private CareerService Cservice;
	
	@GetMapping("/job/delete")
	public @ResponseBody String delete(int j_num, Model model) {
		try{
			Zservice.delete(j_num);
			Dservice.delete(j_num);
			Cservice.delete(j_num);
			
			JobVo vo = Jservice.selectOne(j_num);
			String path = sc.getRealPath("/resources/upload");
			File f1=new File(path + "\\" + vo.getJ_img());
			File f2=new File(path + "\\" + vo.getJ_infoimg());
			
			Jservice.delete(j_num);
			if(f1.exists()) f1.delete();
			if(f2.exists()) f2.delete();
			
			model.addAttribute("result","success");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("result","fail");
		}
		return "job/jobList";
	}
	// 거절 메소드
	@GetMapping(value="/job/remove", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Model rejectJob(int j_num, Model model, Principal principal){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		MemberVo uservo = Jservice.selectUser(principal.getName());
		int userNum = uservo.getM_num();
		map.put("j_num", j_num);
		map.put("m_num", userNum);
		MJservice.delete(map);
		
		try{
			Zservice.delete(j_num);
			Dservice.delete(j_num);
			Cservice.delete(j_num);
			
			JobVo vo = Jservice.selectOne(j_num);
			String path = sc.getRealPath("/resources/upload");
			File f1=new File(path + "\\" + vo.getJ_img());
			File f2=new File(path + "\\" + vo.getJ_infoimg());
			
			Jservice.delete(j_num);
			if(f1.exists()) f1.delete();
			if(f2.exists()) f2.delete();
			
			return model.addAttribute("result","success");
		}catch(Exception e) {
			e.printStackTrace();
			return model.addAttribute("result","fail");
		}
		
	}
}
