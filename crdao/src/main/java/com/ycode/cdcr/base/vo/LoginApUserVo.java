package com.ycode.cdcr.base.vo;

import com.ycode.cdcr.base.entity.APUser;
import java.util.Collection;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author YangLin
 * @createTime 2022/01/11
 */

@Data
public class LoginApUserVo extends APUser implements UserDetails {

  private String token;

  private Long loginTime;

  private Long expireTime;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return null;
  }



  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
