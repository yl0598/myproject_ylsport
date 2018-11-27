package cn.ly.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ly.common.junit.SpringJunitTest;
import cn.ly.core.bean.Testb;
import cn.ly.core.service.TestbService;

public class TestTestb extends SpringJunitTest{

	@Autowired
	private TestbService testbService; 
	
	@Test
	public void testAdd() {
		//ApplicationContext pxa = new ClassPathXmlApplicationContext("application-context.xml");
	     Testb t = new Testb();
	     t.setName("金乐乐");
	     testbService.addTestb(t);
	
	}
}
