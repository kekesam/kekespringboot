package com.mengke.web.upload;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    
	@RequestMapping("/upload")
	public String upload(){
		return "upload/upload";
	}
	
	@RequestMapping("/upload2")
	public String upload2(){
		return "upload/upload2";
	}
	
	
	//springboot 项目发布的问题
	
    //文件上传相关代码
    @RequestMapping(value = "/upload/file")
    //请注意参数的一直性，否则文件上次进入不了 @RequestParam("doc")的doc名字必须保持和控件<input type="file" name="doc"/>的name的名字一致
    @ResponseBody
    public HashMap<String, Object> uploadfile(@RequestParam("doc") MultipartFile file,HttpServletRequest request) {
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        
       //获取文件的后缀
		String ext = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        //String realPath = System.getProperty("user.dir")+"/src/main/resources/static/upload/";
        String realPath = request.getServletContext().getRealPath("/upload");
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
	        map.put("path", "upload"+"/"+newName);//上传成功以后的相对对接
	        map.put("ext", ext);//后缀 jpg
	        map.put("size",file.getSize());//转换后的字节显示
	        return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}