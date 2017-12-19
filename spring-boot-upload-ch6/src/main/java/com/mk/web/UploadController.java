package com.mk.web;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
	@RequestMapping("/upload")
	public String upload(){
		return "upload";
	}
	
	@RequestMapping("/webupload")
	public String webupload(){
		return "webupload";
	}
	
	@RequestMapping("/jqueryupload")
	public String jqueryupload(){
		return "jqueryupload";
	}
	
	@ResponseBody
    @RequestMapping(value = "/upload/file")
    @CrossOrigin(origins="*",maxAge=3600,methods={RequestMethod.GET,RequestMethod.POST})
    public HashMap<String, Object> uploadfile(@RequestParam("doc") MultipartFile file,HttpServletRequest request) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
       //获取文件的后缀
		String ext = fileName.substring(fileName.lastIndexOf("."));
		//获取用户传递过来的参数
		String uploadDir = request.getParameter("dir");
		//设定
		if(uploadDir==null || uploadDir.equals(""))uploadDir = "user";
        // 文件上传后的路径
        String realPath = request.getServletContext().getRealPath("/upload/"+uploadDir);
        File parentDir = new File(realPath);
        if(!parentDir.exists())parentDir.mkdirs();
        // 解决中文问题，liunx下中文路径，图片显示问题
        String newName = UUID.randomUUID() + suffixName;
        File dest = new File(parentDir , newName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            //map装起来
	        HashMap<String, Object> map = new HashMap<String, Object>();
	        map.put("oname", fileName);//logo
	        map.put("newname", newName);//新的文件名
	        map.put("path", "upload"+"/"+uploadDir+"/"+newName);//上传成功以后的相对对接
	        map.put("ext", ext);//后缀 jpg
	        map.put("size",file.getSize());//转换后的字节显示
	        return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}