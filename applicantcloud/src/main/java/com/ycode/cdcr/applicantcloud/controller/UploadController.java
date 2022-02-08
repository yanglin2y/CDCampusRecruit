package com.ycode.cdcr.applicantcloud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ycode.cdcr.applicantcloud.minio.FileUploader;
import com.ycode.cdcr.applicantcloud.service.APUserService;
import com.ycode.cdcr.applicantcloud.util.UserUtil;
import com.ycode.cdcr.base.entity.APUser;
import com.ycode.cdcr.common.web.entity.vo.Result;
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
  APUserService apUserService;
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
        APUser build = APUser.builder().apImg(builder.toString()).build();
        String uid = UserUtil.getLoginUser().getUid();
        FileUploader.delete(hrImg);
        boolean hrid1 = apUserService.update(build, new QueryWrapper<APUser>().eq("uid", uid));
        return hrid1==true?Result.success(builder.toString()):Result.fail("上传失败，请重试");
      }
    } catch (Exception e) {
      log.error("图片上传发生异常", e);
      return Result.fail("图片上传失败");
    }

    return Result.fail("请选择正确的图片");
  }



}