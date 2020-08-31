package com.sw.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/file")
public class FileController {

	private static final Logger logger = LogManager.getLogger(FileController.class);


	@RequestMapping(value="downloadFile",method = RequestMethod.GET)
	@ResponseBody
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String ATTACHMENT_NAME = (String) request.getParameter("ATTACHMENT_NAME");
			ATTACHMENT_NAME = URLDecoder.decode(ATTACHMENT_NAME, "UTF-8");
			logger.info("ATTACHMENT_NAME:"+ATTACHMENT_NAME);
			/*Content-Disposition 响应头指示回复的内容该以何种形式展示，是以内联的形式（即网页或者页面的一部分），还是以附件的形式下载并保存到本地。*/
			response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(ATTACHMENT_NAME, "UTF-8"));
			//告诉浏览器文件类型
			response.setContentType("application/x-msdownload");
			ServletContext ctx = request.getSession().getServletContext();
			InputStream is = ctx.getResourceAsStream("/file/"+ATTACHMENT_NAME);
			OutputStream os = response.getOutputStream();
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = is.read(buffer)) != -1) {
				os.write(buffer, 0, i);
			}
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
