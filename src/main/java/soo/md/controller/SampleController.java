package soo.md.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ViewNameMethodReturnValueHandler;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import soo.md.domain.SampleDTO;
import soo.md.domain.SampleDTOList;
import soo.md.domain.TodoDTO;
import soo.md.filesetting.Path;
import soo.md.service.FileUploadService;

@Controller
@RequestMapping("/sample/*")
@Log4j
@AllArgsConstructor
public class SampleController {
	private FileUploadService service; //Spring 4.3~: AutoInjection ( with @AllArgsConstructor )
	
	@RequestMapping("")
	public void m01() {
		log.info("m01() - default URL");
	}
	@RequestMapping("/base1")
	public void m02() {
		log.info("m02() - Get¹æ½Ä & Post¹æ½Ä & ..");
		
	}
	@RequestMapping(value="/base2", method= {RequestMethod.GET, RequestMethod.POST})
	public void m03() {
		log.info("m03() - Get¹æ½Ä &  Post¹æ½Ä");
		
	}
	@RequestMapping(value="/base3", method= RequestMethod.GET)
	public void m04() {
		log.info("m04() - Get¹æ½Ä ");
	}
	@RequestMapping("/form")
	public String form() {
		return "sample/form";
	}
	
	@RequestMapping("/param1")
	public void m05(@RequestParam String name, @RequestParam int age) {
		log.info("m05() - name: " + name + ", age: " + age);
	}
	@RequestMapping("/param2")
	public void m06(SampleDTO dto) {
		log.info("m06() dto.getName(): " + dto.getName() + ", dto.getAge(): " + dto.getAge());
	}
	@RequestMapping("/param3")
	public void m07(@RequestParam ArrayList<String> names) {
		log.info("m07() names: " + names);
	}
	@RequestMapping("/param4")
	public void m08(@RequestParam("names") ArrayList<String> ns) {
		log.info("m08() ns: " + ns);
	}
	@RequestMapping("/param5")
	public void m09(@RequestParam String[] names) {
		//log.info("m09() names: " + names);
		for(String name: names) {
			log.info("m09() name: " + name);
		}
	}
	
	@RequestMapping("/param6")
	public void m10(SampleDTOList list) {
		log.info("m10() list: " + list); 
	}
	@RequestMapping("/param7")
	public void m11(SampleDTO dto, @RequestParam int page) {
		log.info("m11() dto: " + dto + ", page: " + page);
	}
	@RequestMapping("/param8")
	public void m12(TodoDTO dto) {
		log.info("m12() dto: " + dto); 
		log.info("m12() date: " + dto.getCdate().getDate()); 
		log.info("m12() date: " + dto.getCdate().getDay()); 
 	}
	
	@RequestMapping("/json1")
	public ResponseEntity<String> m13() {
		String json = "{\"name\":\"±èÇü¼·\", \"age\":24}";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		
		return new ResponseEntity<String>(json, headers, HttpStatus.OK);
	}
	@RequestMapping("/json2")
	public @ResponseBody SampleDTO m14(){ //*****
		return new SampleDTO("È²Çýºó", 25);
	}
	
	@GetMapping("/file_form")
	public String formFu() {
		return "sample/file_form";
	}
	@PostMapping("/file_upload")
	public String m15(@RequestParam String name, @RequestParam MultipartFile file) {
		log.info("name: " + name + ", file: " + file);
		
		String ofname = file.getOriginalFilename();
		if(ofname != null) {
			ofname = ofname.trim();
			if(ofname.length() != 0) {
				String url = service.saveStore(file);
				log.info("m15() url: " + url);
			}
		}
		
		return "redirect:file_list";
	}
	@GetMapping("/file_list")
	public ModelAndView fileList() {
		File fStore = new File(Path.FILE_STORE);
		if(!fStore.exists()) fStore.mkdirs();
		File files[] = fStore.listFiles();
		
		return new ModelAndView("sample/file_list", "files", files);		
	}
	@GetMapping("/file_del")
	public String del(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			file.delete();
		}
		
		return "redirect:file_list";
	}
	@GetMapping("/file_download")
	public ModelAndView download(@RequestParam String fname) {
		File file = new File(Path.FILE_STORE, fname);
		if(file.exists()) {
			return new ModelAndView("fileDownloadView", "downloadFile", file);
		}else {
			return new ModelAndView("redirect:file_list");
		}
	}
	
	@GetMapping("/file_form_mt")
	public String formFuMt() {
		return "sample/file_form_mt";
	}
	
	@PostMapping("/file_upload_mt")
	public String m16(@RequestParam ArrayList<MultipartFile> files) {
		for(MultipartFile file : files) {
			String ofname = file.getOriginalFilename();
			if(ofname != null) {
				ofname = ofname.trim();
				if(ofname.length() != 0) {
					String url = service.saveStore(file);
				}
			}
		}
		
		return "redirect:file_list";
	}
}



