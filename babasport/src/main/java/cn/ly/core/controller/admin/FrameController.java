package cn.ly.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/control")
public class FrameController {

	//商品的身体
	@RequestMapping(value="/frame/product_main.do")
	public String product_main() {		
		return "frame/product_main";
	}
	//商品左侧
	@RequestMapping(value="/frame/product_left.do")
	public String product_left() {
		return "frame/product_left";
	}
	
	
	//订单的身体
	
	@RequestMapping(value="/frame/order_main.do")
	public String order_main() {
		return "frame/order_main";
	}
	//订单左侧
	@RequestMapping(value="/frame/order_main.do")
	public String order_left() {
		return "frame/order_left";
	}
	
}
