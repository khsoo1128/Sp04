package soo.md.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;


@RestController
@RequestMapping("rest")
@Log4j
public class RestControllerWithAddress {
	@GetMapping(value="getText", produces = "text/plain;charset=utf-8")
	public String getText() {
		log.info("#getText()");
	    
		return "�ȳ�";
	}
	@GetMapping(value="getAddress", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Address getAddress() {
		return new Address(1, "ȫ�浿", "�����", new Date(2020-1900, 7-1, 20));
	}
	@GetMapping(value="getList", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Address> getList(){
		List<Address> list = new ArrayList<Address>();
		Address a1 = new Address(1, "ȫ�浿", "�����", new Date(2020-1900, 7-1, 20));
		Address a2 = new Address(2, "�̼���", "��õ��", new Date(2020-1900, 7-1, 20));
		list.add(a1); list.add(a2);
		
		return list;
	}
	@GetMapping(value="getMap", 
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Map<String, Address> getMap(){
		Map<String, Address> map = new HashMap<String, Address>();
		Address a1 = new Address(1, "ȫ�浿", "�����", new Date(2020-1900, 7-1, 20));
		Address a2 = new Address(2, "�̼���", "��õ��", new Date(2020-1900, 7-1, 20));
		map.put("first", a1);
		map.put("second", a2);
		
		return map;
	}
	
	//���� ó�� ���� �ڵ带 ���� �����ϴ� �� 
	@GetMapping(value="check")
	public ResponseEntity<Address> check(@RequestParam("height") double h, double weight) {
		log.info("#check() h: " + h + ", weight: " + weight);
		Address a = new Address(1, "ȫ�浿", "�����", new Date(2020-1900, 7-1, 20));
		ResponseEntity<Address> result = null;
		
		if(h>150.0) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(a);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(a);
		}
		
		return result;
	}
	
	//Ŭ���̾�Ʈ ��û path�κ��� ���� �����ϴ� �� 
	@GetMapping(value="product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String c, @PathVariable int pid) {
		String strs[] = {"ī�װ�: " +c + ", ��ǰ���̵�: " + pid};
		
		return strs;
	}
}





