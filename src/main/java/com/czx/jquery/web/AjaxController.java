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
		//创建一个通用的多部分解析器  
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
		//判断 request 是否有文件上传,即多部分请求  
		if(multipartResolver.isMultipart(request)){  
			//转换成多部分request    
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			//取得request中的所有文件名  
			Iterator<String> iter = multiRequest.getFileNames();  
			while(iter.hasNext()){
				//记录上传过程起始时的时间，用来计算上传时间  
				int pre = (int) System.currentTimeMillis();  
				//取得上传文件  
				MultipartFile file = multiRequest.getFile(iter.next());
				if(file != null){  
					//取得当前上传文件的文件名称  
					String myFileName = "new"+file.getOriginalFilename();  
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在  
					if(myFileName.trim() !=""){  
						System.out.println(myFileName);  
						//重命名上传后的文件名  
						String fileName = file.getOriginalFilename();  
						//定义上传路径  
						String path = savePath+"\\"+ fileName;
						File localFile = new File(path);  
						file.transferTo(localFile);  
					}
					objMap.put(file.getOriginalFilename(), myFileName);
				}
				//记录上传该文件后的时间  
				int finaltime = (int) System.currentTimeMillis();  
				System.out.println("spring======================"+(finaltime - pre));  

			}
		}
		response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
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
