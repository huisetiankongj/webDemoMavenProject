package com.czx.baidu.webuploader.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/**
 * 
 * 
 * http://127.0.0.1:8090/webDemoMavenProject/baidu/webuploader/demo.do
 * @author admin
 *
 */
@Controller
@RequestMapping("baidu/webuploader/")
public class DemoController {

	@RequestMapping("demo")
	public Object demo(HttpSession session, HttpServletRequest request) {
		return "baidu/webuploader/demo";
	}
	
	@RequestMapping("simpleMulFile")
	public Object simpleMulFile() {
		return "baidu/webuploader/simpleMulFile2";
	}
	
	@RequestMapping("uploadFile")
	public void uploadFile(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
		//�õ��ϴ��ļ��ı���Ŀ¼�����ϴ����ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = request.getSession().getServletContext().getRealPath("/upload"); 
		File file = new File(savePath);
		//�ж��ϴ��ļ��ı���Ŀ¼�Ƿ����
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
            //����Ŀ¼
            file.mkdir();
        }
        //��Ϣ��ʾ
        String message = "";
        try{
            //ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
            //1������һ��DiskFileItemFactory����
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2������һ���ļ��ϴ�������
            ServletFileUpload upload = new ServletFileUpload(factory);
             //����ϴ��ļ�������������
            upload.setHeaderEncoding("UTF-8"); 
            //3���ж��ύ�����������Ƿ����ϴ���������
            if(!ServletFileUpload.isMultipartContent(request)){
                //���մ�ͳ��ʽ��ȡ����
                return;
            }
            //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //���fileitem�з�װ������ͨ�����������
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //�����ͨ����������ݵ�������������
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value);
                }else{//���fileitem�з�װ�����ϴ��ļ�
                	//��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
    				int pre = (int) System.currentTimeMillis();  
                    //�õ��ϴ����ļ����ƣ�
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
                    //�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //��ȡitem�е��ϴ��ļ���������
                    InputStream in = item.getInputStream();
                    //����һ���ļ������
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //����һ��������
                    byte buffer[] = new byte[1024];
                    //�ж��������е������Ƿ��Ѿ�����ı�ʶ
                    int len = 0;
                    //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
                    while((len=in.read(buffer))>0){
                        //ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
                        out.write(buffer, 0, len);
                    }
                    //�ر�������
                    in.close();
                    //�ر������
                    out.close();
                    //ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
                    item.delete();
                    //��¼�ϴ����ļ����ʱ��  
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println("commonFile======================"+(finaltime - pre));  
                }
          
            }
           
        }catch (Exception e) {
            message= "�ļ��ϴ�ʧ�ܣ�";
            e.printStackTrace();
        }
        
	}
	
	@RequestMapping("uploadFileBySpring")
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
