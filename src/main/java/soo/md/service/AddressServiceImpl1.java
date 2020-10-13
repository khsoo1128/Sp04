package soo.md.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import soo.md.domain.Address;
import soo.md.mapper.AddressMapper1;

@Service("AddressService1")
public class AddressServiceImpl1 implements AddressService {
	@Autowired
	private AddressMapper1 addressMapper1;
	
	@Override
	public List<Address> listS() {
		return addressMapper1.list();
	}
	@Override
	public void insertS(Address address) {
		addressMapper1.insert(address);
	}
	@Override
	public void deleteS(long seq) {
		addressMapper1.delete(seq);
	}

}
