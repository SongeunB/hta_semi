package com.jhta.finalproject.dealcontroller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jhta.finalproject.service.DealService;
import com.jhta.finalproject.vo.DealVo;

@Controller
public class DealInsertController {
	@Autowired private DealService service;
	@GetMapping("/deal/dealinsert")
	public String insertForm() {
		return "deal/dealinsert";
	}
	
	@PostMapping("/deal/dealinsert")
	public String insert(MultipartHttpServletRequest mt, String t_name, String t_explanation, int t_price) {
		List<MultipartFile> fileList = mt.getFiles("file");     
        String path= mt.getRealPath("/resources/goodsimg");
        
        DealVo vo = new DealVo(0,t_name ,t_explanation ,1, t_price , null, null);
        
        service.insert(vo);
        int lastnum = service.lastnum();
        for (MultipartFile mf : fileList) {
            String fileName=mf.getOriginalFilename();
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("lastnum", lastnum);
        	map.put("filename", fileName);
        	service.insertImg(map);
            String safeFile = path +"\\"+ fileName;
            System.out.println(safeFile);
            try {
                mf.transferTo(new File(safeFile));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

		return "result";
	}
}