package com.fadedos.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @Description:测试文件上传下载
 * @author: pengcheng
 * @date: 2021/2/3
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public String upLoad(MultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println("文件名为: " + file.getOriginalFilename());
        System.out.println("文件大小: " + file.getSize());
        System.out.println("文件类型为: " + file.getContentType());

        //文件上传
        //1.根据upload相对路径部署到服务器之后的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        //2.将文件上传到upload对应路径下 (此处上传到绝对路径下,idea上在target目录下的查看)

        //修改原始文件名
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString().replace("-","") + "." + extension;

        //3. 生成当天日期目录
        LocalDate now = LocalDate.now(); //JDK8 2019-02-12
        File dateDir = new File(realPath, now.toString());
        if (!dateDir.exists()) {  //当天第一次上传 需要创建文件夹
            dateDir.mkdirs();
        }
//        file.transferTo(new File(realPath,file.getOriginalFilename()));
//        file.transferTo(new File(realPath,newFileName));

        //4.上传文件到upload对应日期目录中
        file.transferTo(new File(dateDir,newFileName));



        return "index";
    }

    /**
     * 处理文件下载 请求对应响应输出流
     */@RequestMapping("/download")
    public void download(String openStyle,String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        openStyle = openStyle == null ? "inline" : "attachment";
        System.out.println("下载文件的名称: " + fileName);
        //1.根据下载相对目录获取下载目录在服务器部署之后绝对目录
        String realPath = request.getSession().getServletContext().getRealPath("/download");
        //2.通过文件输入流读取文件
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //3. 获取响应输出流
        response.setContentType("text/plain;charset=UTF-8");//设置下载类型和字符编码 文件内容编码
        //4.附件下载 attachment 附件  inline 在线打开
        response.setHeader("content-disposition",openStyle+";fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        //处理下载流复制
        ServletOutputStream outputStream = response.getOutputStream();

        //使用Commons中的工具类 操作流 IOUtils  操作文件 FileUtils
        IOUtils.copy(fis, outputStream);
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(outputStream);

        //传统写法处理下载流复制
//        int len;
//        byte[] buffer = new byte[1024];
//        while ( (len =fis.read(buffer)) != -1) {
//            outputStream.write(buffer,0,len);
//        }
//
//        //释放资源
//        fis.close();
//        outputStream.close();
    }
}
