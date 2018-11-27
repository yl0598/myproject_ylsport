package cn.ly.webservice;

import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WeatherWebService{

	
	public static void main(String[] args) throws IOException {
		//����wsdld��url
		URL url = new URL("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
		//namespaceURL �����ռ��ַ 
		//localPart ������ͼ��
		//������������
		
		QName qName = new QName("http://WebXml.com.cn/", "MobileCodeWS");
		
		//����������ͼ
		//wsdlDocumentLocation wdsl��ַ 
		//serviceName ��������
		
		Service service = Service.create(url, qName);
		//��ȡ����ʵ����
		MobileCodeWSSoap mobileCodeWSSoap = service.getPort(MobileCodeWSSoap.class);
		String mobileCodeInfo = mobileCodeWSSoap.getMobileCodeInfo("18630146006", "");
		System.out.println(mobileCodeInfo);
	}
}
