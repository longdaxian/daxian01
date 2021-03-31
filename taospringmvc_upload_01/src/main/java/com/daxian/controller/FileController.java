package com.daxian.controller;

import com.daxian.utils.UploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public String FileController(String pdesc, MultipartFile upload, HttpServletRequest request){
        System.out.println("文件描述是:"+pdesc);
        //获取文件夹的真实路劲
        String path = request.getSession().getServletContext().getRealPath("file"+ UploadUtils.getDir());
        File file = new File(path);
        //判断file对应的文件夹是否真实存在于硬盘中
        if (!file.exists()) {
            //假如不存在，则将其在硬盘中创建出来
            file.mkdirs();
        }
        //将客户端上传的文件，写入到file文件夹中
        ///获取客户端上传的那个文件名
        String filename = upload.getOriginalFilename();
        String uuidName = UploadUtils.getUUIDName(filename);
        try {
            upload.transferTo(new File(file,uuidName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
