package cn.ly.webservice;

import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WeatherWebService{

	
	public static void main(String[] args) throws IOException {
		//创建wsdld的url
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		//namespaceURL 命名空间地址 
		//localPart 服务视图名
		//创建服务名称
		
		QName qName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
		
		//创建服务视图
		//wsdlDocumentLocation wdsl地址 
		//serviceName 服务名称
		
		Service service = Service.create(url, qName);
		//获取服务实现类
		MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
		String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("18630146006", "");
		System.out.println(mobileCodeInfo);
	}
}
