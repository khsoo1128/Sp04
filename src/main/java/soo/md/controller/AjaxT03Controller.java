package soo.md.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

//@ResponseBody
@Controller
@RequestMapping("ajax03")
@Log4j
public class AjaxT03Controller {
	@Autowired
	private AddressAjaxService service;
	
	@ResponseBody 
	@GetMapping("search01")
	public Address search01(long seq) {
		Address address = service.selectBySeqS(seq);
		return address; //xml, json 
	}
	
	@ResponseBody 
	@PostMapping("search02")
	public List<Address> search02(String name) {
		List<Address> list = service.selectByNameS(name);
		return list; //xml, json 
	}
	
	@GetMapping("m4Controller")
	public String controllerM() { 
		return "ajax/result"; //jsp 
	}
	
	@ResponseBody
	@PostMapping("insertObj") 
	public Address insertObj(@RequestBody Address json) {
		log.info("#AjaxT03Controller insertObj() json: " + json);
		service.insertS(json);

		return json; 
	}
}
