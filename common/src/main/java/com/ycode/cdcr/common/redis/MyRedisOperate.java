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
  private StringRedisTemplate redisTemplate;

  public MyRedisOperate(){

  }

  public boolean keyExists(final String key) {
    return redisTemplate.hasKey(key);
  }

  public void delKey(final String key) {
    redisTemplate.delete(key);
  }

  public String get(final String key) {
    Object obj = redisTemplate.opsForValue().get(key);
    if (obj == null || "nil".equals(obj)) {
      return null;
    }
    return (String) obj;
  }


  public void set(final String key, final String value) {
    redisTemplate.opsForValue().set(key, value);
  }

  public void set(final String key, final String value, final long timeout) {
    redisTemplate.opsForValue().set(key, value);
    redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
  }

  public void leftPush(final String key, final String value) {
    redisTemplate.opsForList().leftPush(key, value);
  }

  public String rightPop(final String key) {
    return redisTemplate.opsForList().rightPop(key);
  }

  public void hIncrement(final String key, final String field, final long count) {
    redisTemplate.opsForHash().increment(key, field, count);
  }

  public Long increment(String key) {
    return redisTemplate.opsForValue().increment(key);
  }

  public void hashPut(String key,Object field,Object object){
    redisTemplate.opsForHash().put(key,field,object);
  }

  public Map<Object, Object> hashGet(String key){
    Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
    return map;
  }

  public List<Object> hashGetValues(String key){
    List<Object> objects = redisTemplate.opsForHash().values(key);
    return objects;
  }

  public Boolean hasHashKey(String key,Object field){
    return redisTemplate.opsForHash().hasKey(key,field);
  }

  public void deleteHashKey(String key,Object... field){
    redisTemplate.opsForHash().delete(key,field);
  }

}
