package cn.ly.core.controller.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import cn.ly.common.web.Constants;
import cn.ly.common.web.ResponseUtils;


/**
 * 上传图片
 * 商品
 * 品牌
 * @author Administrator
 *
 */
@Controller
public class UploadController {

   @RequestMapping(value="/upload/uploadPic.do")
   public void uploadPic(@RequestParam(required=false) MultipartFile pic,HttpServletResponse response ) {
		//获取图片扩展名
	   String extension = FilenameUtils.getExtension(pic.getOriginalFilename());
	   
	   //图片名称生成规则
	    SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	    String format = ft.format(new Date());
	     //随机三位数
	     Random random = new Random();
	    for(int i=0;i<3;i++) {
	    	format +=random.nextInt(10);
	    }
	   //实例化一个jersey
		Client client = new Client();
		//另一台服务器的请求路径
		  //相对路径
		String path="upload/"+format+"."+extension;
		
		String url=Constants.IMAGE_URL + path;
		//设置请求路径
		WebResource resource = client.resource(url);
		
		//本地路径
//		String path="C:\\Users\\Administrator\\Desktop\\5be40a3fN0f1bb039.jpg";
//		
//		//读取图片到内存中
//		byte[] readFileToByteArray;
//		try {
//			readFileToByteArray = FileUtils.readFileToByteArray(new File(path));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//开始发送
		try {
			resource.put(String.class,pic.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//返回路径
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("url", url);
		jsonObject.put("path", path);
//		try {
//			response.getWriter().write(jsonObject.toString());
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		ResponseUtils.renderJson(response, jsonObject.toString());
		
		
   }
}
