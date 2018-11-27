package cn.ly.core.controller.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
/****
 * 后台测试
 * @author Administrator
 *
 */


@Controller
@RequestMapping(value = "/control")
public class CenterController{

	@RequestMapping(value="/test/springmvc.do")
	public String test(String name,Date birthday) {
		
		System.out.println("name="+name+"birthday="+birthday );
		
		return "";
	}

	//局部日期格式转换
//	@InitBinder
//	public void initBinder(WebDataBinder binder, WebRequest request) {
//		//转换日期格式
//		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//		
//	}
	
	
	//跳转入口页面
	@RequestMapping(value="/index.do")
	public String index() {	
		return "index";
	}
	
	@RequestMapping(value="/top.do")
	public String top() {
		return "top";
	}
	
	@RequestMapping(value="/main.do")
	public String main() {
		return "main";
	}
	@RequestMapping(value="/left.do")
	public String left() {
		return "left";
	}
	@RequestMapping(value="/right.do")
	public String right() {
		return "right";
	}
}
