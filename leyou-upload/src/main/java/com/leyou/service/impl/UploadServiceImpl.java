package com.leyou.service.impl;

import com.leyou.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {
    private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);
    private static final List<String> CONTENT_TYPES = Arrays.asList("image/png", "image/jpeg", "image/jpg");
    private static final String filePath = "E:\\tools\\upload\\";
    private static final String url = "http://image.leyou.com/";

    @Override
    public String uploadImage(MultipartFile file) {
        // 1、图片信息校验
        // 1)校验文件类型
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        try {
//        String afterLast = StringUtils.substringAfterLast(originalFilename, ".");
            String fileType = file.getContentType();
            if (!CONTENT_TYPES.contains(fileType)) {
                log.error("上传失败，文件类型不匹配{}", originalFilename);
                return null;
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null || image.getHeight() == 0 || image.getWidth() == 0) {
                log.error("上传失败，文件内容不符合要求");
                return null;
            }
            // 2、保存图片
            // 2.1、保存到服务器
            file.transferTo(new File(filePath + originalFilename));

            // 2.3、返回url,进行回显
            System.out.println(url + originalFilename);
            return url + originalFilename;
        } catch (IOException e) {
            log.error("服务器内部错误: {}" + originalFilename);
        }
        return null;
    }
}
