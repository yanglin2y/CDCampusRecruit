package com.ycode.cdcr.common.web.entity.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;

/**
 * @author YangLin
 * @createTime 2022/01/10
 */

@Getter
public class Result<T>  {

  public final static String SUCCESS_CODE = "000000";
  public final static String SUCCESS_MESG = "处理成功";
  public final static String FAIL_CODE = "111111";

  /**
   * 错误码
   */
  private String code;
  /**
   * 错误提示
   */
  private String message;
  /**
   * 返回数据
   */
  private T data;
  private String time;
  private Result(String code,String message,T data){
    this.code = code;
    this.message = message;
    this.data =data;
    this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  private Result(String code,String message){
    this.code = code;
    this.message = message;
    this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public static Result success(Object data){
    return new Result<>(SUCCESS_CODE,SUCCESS_MESG,data);
  }
  public static Result success(String message,Object data){
    return new Result(SUCCESS_CODE,message,data);
  }
  public static Result fail(String message){
    return new Result(FAIL_CODE,message);
  }
  public static Result fail(Object data){
    return new Result(FAIL_CODE,"1111111",data);
  }
  public static Result fail(String code,String message){
    return new Result(code,message);
  }

  public boolean jugSuccess() { // 方便判断是否成功
    return SUCCESS_CODE.equals(code);
  }

  public boolean jugError() { // 方便判断是否失败
    return !jugSuccess();
  }


}
