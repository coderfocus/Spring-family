package com.coderfocus.springbootthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {

    /** 
    * @Description: 上传单个文件 
    * @param: [file]
    * @return: java.lang.String 
    * @Author: songwenjie
    * @Date: 2019/8/9 
    */ 
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // 这里只是简单例子，文件直接输出到项目路径下。
                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。默认上传到根目录下
                // 还有关于文件格式限制、文件大小限制，详见：中配置。
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "上传成功";
        } else {
            return "上传失败，文件为空";
        }
    }


    /** 
    * @Description: 上传多个文件包括参数
    * @param: [request]
    * @return: java.lang.String 
    * @Author: songwenjie
    * @Date: 2019/8/9 
    */ 
    @RequestMapping(value = "/batch/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request)
                .getFiles("file");

        String name = params.getParameter("name");
        System.out.println("name:"+name);
        String id = params.getParameter("id");
        System.out.println("id:"+id);


        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("spring-boot-thymeleaf-demo\\src\\main\\resources\\static\\images\\",file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "上传失败," + e.getMessage();
                }
            } else {
                return "上传失败，文件为空";
            }
        }
        return "上传成功";
    }

    @RequestMapping(value = "/img/upload", method = RequestMethod.POST)
    @ResponseBody
    public String imgUpdate(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = "E://images/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "文件成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "文件上传失败";

    }

}
