package cn.ly.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ly.core.bean.Testb;
import cn.ly.core.dao.TestbDao;



@Service
@Transactional
public class TestbServiceImpl implements TestbService{

	@Resource
	private TestbDao testbDao;
	
	@Override
	public void addTestb(Testb testb) {
	
		testbDao.addTestb(testb);
		
		//throw new RuntimeException();
	}

}
