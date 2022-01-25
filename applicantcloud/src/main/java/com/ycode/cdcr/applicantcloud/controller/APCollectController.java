package com.ycode.cdcr.applicantcloud.controller;

import com.ycode.cdcr.applicantcloud.service.APCollectionService;
import com.ycode.cdcr.common.web.entity.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YangLin
 * @createTime 2022/01/22
 * 职位收藏功能
 */
@RestController
@RequestMapping("collection")
public class APCollectController {
  @Autowired
  APCollectionService apCollectionService;

  /**
   * 查询收藏
   * @return
   */
  @GetMapping("selectCollection")
  public Result selectCollection(){
    return apCollectionService.selectCollection();
  }

  @PostMapping ("addCollection")
  public Result addCollection(Integer rpid) {
    return apCollectionService.addCollection(rpid);
  }

  @PostMapping("delCollection")
  public Result delCollection(Integer rpid) {
    return apCollectionService.delCollection(rpid);
  }

}
