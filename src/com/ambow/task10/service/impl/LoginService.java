package com.ambow.task10.service.impl;

/**
 * 登录服务
 *
 * @author w
 * @date 2020/10/11
 */
public class LoginService {

  /**
   * 登录
   *
   * @param name 名字
   * @param password 密码
   * @return boolean
   */
  public boolean login(String name, String password) {

    if ("123".equals(name) && "123".equals(password)) {
      return true;
    } else if ("admin".equals(name) && "admin".equals(password)) {
      return true;
    }
    return false;
  }
}
