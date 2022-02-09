package com.ycode.cdcr.common.redis;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author YangLin
 * @createTime 2022/01/12
 */
@Service
public class MyRedisOperate {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public MyRedisOperate(){

  }

  public boolean keyExists(final String key) {
    return stringRedisTemplate.hasKey(key);
  }

  public void delKey(final String key) {
    stringRedisTemplate.delete(key);
  }

  public String get(final String key) {
    Object obj = stringRedisTemplate.opsForValue().get(key);
    if (obj == null || "nil".equals(obj)) {
      return null;
    }
    return (String) obj;
  }


  public void set(final String key, final String value) {
    stringRedisTemplate.opsForValue().set(key, value);
  }

  public void set(final String key, final String value, final long timeout) {
    stringRedisTemplate.opsForValue().set(key, value);
    stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
  }

  public void leftPush(final String key, final String value) {
    stringRedisTemplate.opsForList().leftPush(key, value);
  }

  public String rightPop(final String key) {
    return stringRedisTemplate.opsForList().rightPop(key);
  }

  public void hIncrement(final String key, final String field, final long count) {
    stringRedisTemplate.opsForHash().increment(key, field, count);
  }

  public Long increment(String key) {
    return stringRedisTemplate.opsForValue().increment(key);
  }

  public void hashPut(String key,Object field,Object object){
    stringRedisTemplate.opsForHash().put(key,field,object);
  }

  public Map<Object, Object> hashGet(String key){
    Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(key);
    return map;
  }

  public List<Object> hashGetValues(String key){
    List<Object> objects = stringRedisTemplate.opsForHash().values(key);
    return objects;
  }

  public Boolean hasHashKey(String key,Object field){
    return stringRedisTemplate.opsForHash().hasKey(key,field);
  }

  public void deleteHashKey(String key,Object... field){
    stringRedisTemplate.opsForHash().delete(key,field);
  }

}
