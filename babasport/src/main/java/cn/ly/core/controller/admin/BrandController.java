package cn.ly.core.controller.admin;

import java.awt.Dialog.ModalExclusionType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.ly.core.bean.product.Brand;
import cn.ly.core.service.product.BrandService;
import net.spy.memcached.transcoders.IntegerTranscoder;


@Controller
public class BrandController {

/**
 * 品牌
 */
	
  @Autowired
  private BrandService brandService;
	
	
  @RequestMapping(value="/brand/list.do")
  public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model) {
	      Brand brand = new Brand();
	      StringBuilder params = new StringBuilder();
		 if(StringUtils.isNotBlank(name)) {
			 brand.setName(name);
			 params.append("name=").append(name);
		 }
		 if(null != isDisplay) {
			 brand.setIsDisplay(isDisplay);
			 params.append("&isDisplay=").append(isDisplay);
		 }else {
			 brand.setIsDisplay(1);
			 params.append("&isDisplay=").append(1);
		 }
		
		//页号为null或小于1 则置为1Pagination.cpn(pageNo);		
	    brand.setPageNo(Pagination.cpn(pageNo));
	    //每页数
	    brand.setpageSize(3);
	    
	    Pagination pagination = brandService.getBrandListWithPage(brand);
	    
	    //显示分页
	    String url="/brand/list.do";
	    pagination.pageView(url, params.toString());
	    model.addAttribute("pagination",pagination);
	    //回显搜索条件
	    model.addAttribute("searchName",name);
	    model.addAttribute("isDisplay", isDisplay);
	  return "brand/list";
  }
  
  //跳转品牌添加页面
  @RequestMapping(value="/brand/toAdd.do")
  public String toadd() {
	  return "brand/add";
  }
  
  //添加品牌
  @RequestMapping(value="/brand/addBrand.do")
  public String addBrand(Brand brand) {
	 
	  brandService.addBrand(brand);
	  return "redirect:/brand/list.do";
	  
  }
  //删除品牌
  @RequestMapping(value="/brand/delete.do")
  public String delete(ModelMap model,Integer id,String name,Integer isDisplay) {
	 brandService.deleteBrandByKey(id);
	 if(StringUtils.isNotBlank(name)) {
		 model.addAttribute("name",name);
	 } 
	 if(null != isDisplay) {
		 model.addAttribute("isDisplay",isDisplay);
	 }
	  return "redirect:/brand/list.do";
  }
}
