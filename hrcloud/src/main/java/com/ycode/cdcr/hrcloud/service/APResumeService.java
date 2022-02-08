package com.ycode.cdcr.hrcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycode.cdcr.base.entity.APResume;
import com.ycode.cdcr.common.web.entity.vo.Result;

public interface APResumeService extends IService<APResume> {
  Result updataApResume(String uid,String rpid);
  Result passApResume(String uid,String rpid);
  Result delApResume(String uid,String rpid);
}
