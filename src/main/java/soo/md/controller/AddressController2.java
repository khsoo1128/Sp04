package soo.md.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import soo.md.domain.Address;
import soo.md.service.AddressService;

@RequestMapping("/address2/*")
@Controller
public class AddressController2 {
	//@Autowired
	@Resource(name="AddressService2")
	private AddressService service;
	
	@RequestMapping("/list.do")
	public ModelAndView list() { 
		List<Address> list = service.listS();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("address2/list");
		mv.addObject("list", list);
		
		return mv;
	}
	@GetMapping("/write.do")
	public String write() {
		return "address2/write";
	}
	@PostMapping("/write.do")
	public String write(Address address) {
		service.insertS(address);
		return "redirect:list.do";
	}
	@GetMapping("/del.do")
	public String delete(@RequestParam long seq) {
		service.deleteS(seq);
		return "redirect:list.do";
	}
}
