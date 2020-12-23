package com.ambow.task10;

import com.ambow.task10.pojo.Video;
import com.ambow.task10.service.IVideoService;
import com.ambow.task10.service.impl.LoginService;
import com.ambow.task10.service.impl.VideoListService;

import java.util.Scanner;

public class Main {

  private static final Scanner SCANNER = new Scanner(System.in);

  private static final LoginService loginService = new LoginService();

  private static final IVideoService videoService = new VideoListService();

  private static final int TRY_MAX = 3;

  public static void main(String[] args) {

    System.out.println("-------------------------------");
    System.out.println("---- 欢迎使用视频管理系统  ----");
    System.out.println("-------------------------------");
    System.out.println("");

    // 登陆模块
    boolean isLogin = false;
    for (int i = 1; i <= TRY_MAX; ++i) {

      System.out.println("请输入用户名：");
      String userName = SCANNER.nextLine();
      System.out.println("请输入密码：");
      String userPwd = SCANNER.nextLine();
      isLogin = loginService.login(userName, userPwd);
      if (isLogin) {
        break;
      } else {
        System.out.println("密码不正确！还有" + (TRY_MAX - i) + "次机会！");
      }
    }

    if (isLogin) {
      String choice;
      do {
        try {
          System.out.println("---------视频管理子菜单--------");
          System.out.println("- 模糊查询视频 \t选择 1");
          System.out.println("- 查询全部视频 \t选择 2");
          System.out.println("- 添加视频 \t选择 3");
          System.out.println("- 修改视频 \t选择 4");
          System.out.println("- 删除视频 \t选择 5");
          System.out.println("- 结束 \t选择 0");
          System.out.println("-------------------------------");

          System.out.println("请输入选项：");
          choice = SCANNER.nextLine();

          switch (choice) {
            case "1":
              System.out.println("请输入视频名称：");
              String name = SCANNER.nextLine();
              videoService.searchByName(name);
              break;
            case "2":
              videoService.printAll();
              break;
            case "3":
              addVideo();
              break;
            case "4":
              updateVideo();
              break;
            case "5":
              deleteVideo();
              break;
            case "0":
              return;
            default:
              System.out.println("请输入正确的选项！");
              break;
          }

        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("请输入正确的选项！");
        }
      } while (true);
    }

    System.out.println("-------------------------------");
    System.out.println("---- 感谢使用视频管理系统  ----");
    System.out.println("-------------------------------");
    System.out.println("");
  }

  private static void deleteVideo() {
    System.out.println("请输入要删除视频的编号：");
    long id = SCANNER.nextLong();
    SCANNER.nextLine();

    Video video = videoService.getById(id);
    if (video == null) {
      System.out.println("无效的ID！");
      return;
    }

    videoService.deleteVideo(id);
    System.out.println("编号为" + id + "视频信息为：" + video + "已删除！");
  }

  private static void updateVideo() {
    System.out.println("请输入要修改视频的编号：");
    long id = SCANNER.nextLong();
    SCANNER.nextLine();

    Video video = videoService.getById(id);
    if (video == null) {
      System.out.println("无效的ID！");
      return;
    }
    System.out.println("编号为" + id + "视频信息为：" + video);
    System.out.println("请输入名字：");
    String name = SCANNER.nextLine();
    System.out.println("请输入演员：");
    String actors = SCANNER.nextLine();
    System.out.println("请输入简介：");
    String content = SCANNER.nextLine();
    videoService.updateVideo(id, name, actors, content);
  }

  private static void addVideo() {
    System.out.println("请输入编号：");
    long id = SCANNER.nextLong();
    SCANNER.nextLine();
    System.out.println("请输入名字：");
    String name = SCANNER.nextLine();
    System.out.println("请输入演员：");
    String actors = SCANNER.nextLine();
    System.out.println("请输入简介：");
    String content = SCANNER.nextLine();
    videoService.addVideo(id, name, actors, content);
  }
}
