package com.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.file.customexception.ResourceNotFoundException;
import com.file.service.DocService;
import com.file.service.UserService;
import com.file.utils.DateFormatUtil;
import com.file.utils.UtilFile;
import com.file.utils.FileTransferUtil;
import com.file.vo.Page;
import com.file.vo.Doc;

@Controller
@RequestMapping(value="/doc")
public class DocController {
	@Resource
	private DocService docService;
	@Resource
	private UserService userService;
	@RequestMapping(value = "/upload.do",method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}
	@RequestMapping(value = "/upload.do",method = RequestMethod.POST)
	public String doUpload(@RequestParam("doc") CommonsMultipartFile[] uploadfiles,HttpServletRequest request) throws FileNotFoundException, IOException {
//		获取用户id
		int user_id = (int) request.getSession().getAttribute("user_id");
		//获取文件存储的目录
		ServletContext servletContext = request.getServletContext();
		String uploadPath = servletContext.getAttribute("uploadPath").toString()+user_id;
		File file = new File(uploadPath);
		//判断用户目录是否存在
		if (!file.exists()) {
			file.mkdirs();
		}
		for (int i = 0; i < uploadfiles.length; i++) {
			CommonsMultipartFile uploadfile = uploadfiles[i] ;
			if(uploadfile.isEmpty()){
				throw new ResourceNotFoundException("上传文件不存在") ;
			}
			//获取文件名称，可以修改名称
			String doc_name_o = uploadfile.getOriginalFilename();
			String doc_name_n = System.currentTimeMillis() + "-" +  doc_name_o;
			//获取文件上传的输入流
			//获取文件写出的文件流
			InputStream is = uploadfile.getInputStream();
			OutputStream os = new FileOutputStream(uploadPath + File.separator + doc_name_n);
			String doc_size = UtilFile.getFizeSizeString(is.available());
			FileTransferUtil.inputStreanToOuputStream(is,os);
			String doc_ctime = DateFormatUtil.getTimeString();
			Doc doc = new Doc(doc_name_o, doc_name_n, doc_ctime, doc_size, user_id);
			docService.addDocByDoc(doc);
		}
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/list.do")
	public String list(Integer current_page,ModelMap map,HttpServletRequest request) {
		current_page = current_page == null ? 1 : current_page;
		int user_id = (int) request.getSession().getAttribute("user_id");
		int total_rows = docService.getDocNumByUserId(user_id);
		int page_size = 5 ;
		Page page = new Page(total_rows, current_page, page_size);
		List<Doc> docs = docService.getDocsByPageAndUserId(page, user_id);
		map.put("docs", docs);
		map.put("page", page);
		return "list";
	}
	@RequestMapping(value = "/download.do",method = RequestMethod.GET)
	public void download(Integer doc_id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if (doc_id == null) {
		}
		//获取文件存储的目录
		Doc doc = docService.getDocById(doc_id);
		if (doc == null) {
		}
		ServletContext servletContext = request.getServletContext();
		String uploadPath = servletContext.getAttribute("uploadPath").toString();
		int  user_id = (int) request.getSession().getAttribute("user_id");
		String fileName = UtilFile.transCharacter(request, doc.getDoc_name_o());
		File file = new File(uploadPath + user_id + File.separator+doc.getDoc_name_n());
		//设置输出流的消息头
		response.setCharacterEncoding("UTF-8");
		//设置响应内容的类型及编码
		response.setContentType("application/octet-stream;charset=UTF-8"); 
		//告诉浏览器这是一个附件，并指定名称
		response.setHeader("Content-Disposition", "attachment;fileName=" +fileName);
		//告诉浏览器显示文件的长度
		response.addHeader("Content-Length", "" + file.length());  
		try {
			InputStream is = new FileInputStream(file);
			OutputStream os = response.getOutputStream();
			try {
				//复制文件
				byte[] b = new byte[1024*1024] ;
				int len = 0 ;
				while(-1!=(len = is.read(b, 0, b.length))){
					os.write(b, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				//关闭流
				try {
					if(os!=null){
						os.flush();
						os.close();
					}
					if(is!=null){
						is.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping(value = "/rename.do",method = RequestMethod.GET)
	public void rename(Integer doc_id,HttpServletRequest request,HttpServletResponse response) {
		int user_id = (int) request.getSession().getAttribute("user_id");
	}
	
}
