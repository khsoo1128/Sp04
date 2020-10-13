package soo.md.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.extern.log4j.Log4j;
import soo.md.service.DragdropService;

@Log4j
@RequestMapping("file")
@Controller
public class DragdropController {
	@GetMapping("form_dd")
	public String form() {
		return "drag_drop/form";
	}
	
	@Autowired
	private DragdropService service;
	
	@PostMapping("fileUpload")
	public String fileUpload(MultipartHttpServletRequest multipartRequest) {
		service.setMultipartRequest(multipartRequest);
		Map<String, List<String>> map = service.getUpdateFileName();
		log.info("#DragdropController fileUpload() map: " + map);
		
		String appendData = multipartRequest.getParameter("temp");
		log.info("#DragdropController fileUpload() appendData: " + appendData);
		
		return "redirect:list";
	}
}
