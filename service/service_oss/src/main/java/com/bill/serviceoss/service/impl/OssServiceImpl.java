package com.bill.serviceoss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.bill.serviceoss.service.OssService;
import com.bill.serviceoss.utils.ConstantPropertiesUtil;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author Bill Lee
 * @description:
 * @date 2021/6/17 21:05
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {

        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;

        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = ConstantPropertiesUtil.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId =  ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;

        try {
         // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = file.getInputStream();

            String fileName = file.getOriginalFilename();

            String id = UUID.randomUUID().toString().replace("-", "");

            String path = new DateTime().toString("yyyy/MM/ss");

            fileName = path+id+fileName;

            // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(bucketName, fileName, inputStream);

            // 关闭OSSClient。
            ossClient.shutdown();

            //https://university-bill.oss-cn-shanghai.aliyuncs.com/x.png?versionId=CAEQGxiBgICytc_A0BciIGRmNzE2NGQxNzcwZDRmNWNhOThmYWQ0MGMxOGY3MWUz
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;

            return url;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
