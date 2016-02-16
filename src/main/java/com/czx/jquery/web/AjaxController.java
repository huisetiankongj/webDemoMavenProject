package com.czx.jquery.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * 
 * http://127.0.0.1:8090/webDemoMavenProject/jquery/ajax/ajaxDemo.do
 * @author admin
 * 
 * 
 *
 */
@Controller
@RequestMapping("jquery/")
public class AjaxController {

	@RequestMapping("ajax/ajaxDemo")
	public Object deferredDemo(HttpServletRequest request) {
		String fname = request.getParameter("name");
		System.out.println(fname);
		return "jquery/self/ajaxDemo";
	}
	
	@RequestMapping("ajax/uploadFileBySpring")
	public void uploadFileBySpring(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		Map<String,Object> objMap = new HashMap<String, Object>();
		String savePath = request.getSession().getServletContext().getRealPath("/upload"); 
		//����һ��ͨ�õĶಿ�ֽ�����  
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		//�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
		if(multipartResolver.isMultipart(request)){  
			//ת���ɶಿ��request    
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//ȡ��request�е������ļ���  
			Iterator<String> iter = multiRequest.getFileNames();  
			while(iter.hasNext()){
				//��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
				int pre = (int) System.currentTimeMillis();  
				//ȡ���ϴ��ļ�  
				MultipartFile file = multiRequest.getFile(iter.next());
				if(file != null){  
					//ȡ�õ�ǰ�ϴ��ļ����ļ�����  
					String myFileName = "new"+file.getOriginalFilename();  
					//������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
					if(myFileName.trim() !=""){  
						System.out.println(myFileName);  
						//�������ϴ�����ļ���  
						String fileName = file.getOriginalFilename();  
						//�����ϴ�·��  
						String path = savePath+"\\"+ fileName;
						File localFile = new File(path);  
						file.transferTo(localFile);  
					}
					objMap.put(file.getOriginalFilename(), myFileName);
				}
				//��¼�ϴ����ļ����ʱ��  
				int finaltime = (int) System.currentTimeMillis();  
				System.out.println("spring======================"+(finaltime - pre));  

			}
		}
		response.setCharacterEncoding("UTF-8");//���ý��ַ���"UTF-8"����������ͻ��������
 		response.setHeader("content-type", "text/html;charset=UTF-8");
 		PrintWriter out = null;
 		try {
 			out = response.getWriter();
 			out.write(System.currentTimeMillis()+".jpg");
 		}catch (Exception e) {
				// TODO: handle exception
		}

	}
}
