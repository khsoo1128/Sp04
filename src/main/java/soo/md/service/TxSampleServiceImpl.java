package soo.md.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import soo.md.mapper.TxSample1Mapper;
import soo.md.mapper.TxSample2Mapper;

@Log4j
@Service
public class TxSampleServiceImpl implements TxSampleService {
	@Autowired
	private TxSample1Mapper mapper1;
	@Autowired
	private TxSample2Mapper mapper2;
	
	@Transactional
	@Override
	public void doDmlN(String data) {
		log.info("#TxSampleServiceImpl doDmlN() Step 1");
		mapper1.insertT1(data);
		log.info("#TxSampleServiceImpl doDmlN() Step 2");
		mapper2.insertT2(data);
		log.info("#TxSampleServiceImpl doDmlN() Step 3");
	}
}



