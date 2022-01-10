package com.ycode.cdcr.common.util;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangLin
 * @createTime 2022/01/11
 */
public class ResponseUtil {
  public static void responseJson(HttpServletResponse response, int status, Object data){
    try{
      response.setHeader("Access-Control-Allow-Origin", "*");
      /* 星号表示所有的域都可以接受， */
      response.setHeader("Access-Control-Allow-Methods", "*");
      response.setContentType("application/json;charset=UTF-8");
      response.setStatus(status);
      response.getWriter().write(JSONObject.toJSONString(data));
    }catch (IOException e){
      e.printStackTrace();
    }
  }

}
