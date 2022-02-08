package com.ycode.cdcr.entcloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.base.entity.EntInfo;
import com.ycode.cdcr.common.web.entity.vo.Result;
import com.ycode.cdcr.entcloud.minio.FileUploader;
import com.ycode.cdcr.entcloud.service.EntInfoService;
import com.ycode.cdcr.entcloud.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author weiyunjie
 * @date 2020/5/22
 */
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {
  @Autowired
  EntInfoService entInfoService;
  @PostMapping("img")
  public Result uploadImg(MultipartFile[] files,String hrImg) {
    try {
      if (files != null) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
          // 添加毫秒时间戳前缀
          String originalFilename = files[i].getOriginalFilename();
          originalFilename = System.currentTimeMillis() + "-" + originalFilename;
          String url = FileUploader.uploadImg(originalFilename, files[i].getInputStream());
          builder.append(url);

          // 最后一个不拼接逗号
          if (i < files.length - 1) {
            builder.append(",");
          }
        }
        EntInfo build = EntInfo.builder().entImg(builder.toString()).build();
        String eid = UserUtil.getLoginUser().getEid();
        FileUploader.delete(hrImg);
        boolean hrid1 = entInfoService.update(build, new QueryWrapper<EntInfo>().eq("eid", eid));
        return hrid1==true?Result.success(builder.toString()):Result.fail("上传失败，请重试");
      }
    } catch (Exception e) {
      log.error("图片上传发生异常", e);
      return Result.fail("图片上传失败");
    }

    return Result.fail("请选择正确的图片");
  }



}