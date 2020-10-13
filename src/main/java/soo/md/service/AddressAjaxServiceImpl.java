package soo.md.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
import soo.md.dao.AddressDao;
import soo.md.domain.Address;
import soo.md.mapper.AddressAjaxMapper;

@Service
@Log4j
public class AddressAjaxServiceImpl implements AddressAjaxService {
	@Autowired
    private AddressAjaxMapper mapper;
    
	@Override
	public List<Address> listS() {
		return mapper.list();
	}
	@Override
	public void insertS(Address address) {		
		mapper.insert(address);
	}
	@Override
	public void deleteS(long seq) {
		mapper.delete(seq);
	}
	
	//for Ajax
	public Address selectBySeqS(long seq) {
		return mapper.selectBySeq(seq);
	}
	public List<Address> selectByNameS(String name){
		return mapper.selectByName(name);
	}
}
