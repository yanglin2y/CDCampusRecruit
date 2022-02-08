package com.ycode.cdcr.hrcloud.filter;

import com.ycode.cdcr.base.vo.LoginHrVo;
import com.ycode.cdcr.hrcloud.service.TokenService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author YangLin
 * @createTime 2022/01/04
 */
@Component
public class TokenFilter extends OncePerRequestFilter {

  public static final String TOKEN_KEY = "hrToken";
  @Autowired
  private TokenService tokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, FilterChain filterChain)
      throws ServletException, IOException {
    String token = getToken(httpServletRequest);
    if (!StringUtils.isEmpty(token)) {
      LoginHrVo loginEntVo = tokenService.getLoginUser(token);
      if (loginEntVo != null) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            loginEntVo, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
    }
    filterChain.doFilter(httpServletRequest, httpServletResponse);

  }

  public static String getToken(HttpServletRequest request) {
    String token = request.getParameter(TOKEN_KEY);
    if (StringUtils.isEmpty(token)) {
      token = request.getHeader(TOKEN_KEY);
    }
    if (StringUtils.isEmpty(token)) {
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
        for (Cookie cookie : cookies) {
          if (TOKEN_KEY.equals(cookie.getName())) {
            token = cookie.getValue();
            break;
          }
        }
      }
    }
    return token;

  }
}
