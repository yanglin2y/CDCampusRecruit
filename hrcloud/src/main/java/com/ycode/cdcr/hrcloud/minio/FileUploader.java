package com.ycode.cdcr.hrcloud.minio;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.MinioException;
import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;

@Slf4j
public class FileUploader {

    private static String PUBLIC_BUCKET = "crcd";
    private static String ip = "http://127.0.01:9001";

    public static String uploadImg(String fileName, InputStream inputStream) throws Exception {
        try {
            String folder = "/img/";
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = MinioClient.builder().endpoint(ip).credentials("admin","admin123456").build();
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(
                BucketExistsArgs.builder().bucket(PUBLIC_BUCKET).build());
            if(!isExist) {
                // 创建一个存储桶
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(PUBLIC_BUCKET).build());
            }
            // 使用putObject上传一个图片文件到存储桶中。
            minioClient.putObject(PutObjectArgs.builder().bucket(PUBLIC_BUCKET).stream(inputStream,
                inputStream.available(), -1).object(folder+fileName).contentType(ContentType.IMAGE_JPEG.getMimeType()).build());
            log.info(ip+"/"+PUBLIC_BUCKET+folder+fileName);
            return ip+"/"+PUBLIC_BUCKET+folder+fileName;
        } catch(MinioException e) {
            log.error("错误",e);
        }
        return null;
    }
    public static String delete(String filename){
        try {
            MinioClient minioClient = MinioClient.builder().endpoint(ip).credentials("admin","admin123456").build();
            minioClient.removeObject(RemoveObjectArgs.builder().bucket(PUBLIC_BUCKET).object(filename.substring(26)).build());
        } catch (Exception e) {
            return "删除失败"+e.getMessage();
        }
        return "删除成功";
    }


}