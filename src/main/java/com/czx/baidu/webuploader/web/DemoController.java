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
		//得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		String savePath = request.getSession().getServletContext().getRealPath("/upload"); 
		File file = new File(savePath);
		//判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath+"目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //消息提示
        String message = "";
        try{
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
             //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8"); 
            //3、判断提交上来的数据是否是上传表单的数据
            if(!ServletFileUpload.isMultipartContent(request)){
                //按照传统方式获取数据
                return;
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    //value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value);
                }else{//如果fileitem中封装的是上传文件
                	//记录上传过程起始时的时间，用来计算上传时间  
    				int pre = (int) System.currentTimeMillis();  
                    //得到上传的文件名称，
                    String filename = item.getName();
                    System.out.println(filename);
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\")+1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    //记录上传该文件后的时间  
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println("commonFile======================"+(finaltime - pre));  
                }
          
            }
           
        }catch (Exception e) {
            message= "文件上传失败！";
            e.printStackTrace();
        }
        
	}
	
	@RequestMapping("uploadFileBySpring")
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
