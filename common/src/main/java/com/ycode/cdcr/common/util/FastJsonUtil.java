package com.ycode.cdcr.common.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * @author YangLin
 * @createTime 2022/01/12
 */
public class FastJsonUtil {
  private static final Logger logger = LoggerFactory.getLogger(FastJsonUtil.class);

  public static <T> T toBeanFromStr(String jsonStr,Class<T> c){
    if (StringUtils.isEmpty(jsonStr)){
      return null;
    }else {
      try {
        return JSONObject.parseObject(jsonStr, c);
      } catch (Exception var5) {
        if (jsonStr.contains("\\")) {
          try {
            jsonStr = jsonStr.replace("\\", "\\\\");
            return JSONObject.parseObject(jsonStr, c);
          } catch (Exception var4) {
            logger.error("JSON转对象出错，jsonStr=" + jsonStr, var4);
          }
        } else {
          logger.error("JSON转对象出错，jsonStr=" + jsonStr, var5);
        }

        return null;
      }
    }
  }

}
