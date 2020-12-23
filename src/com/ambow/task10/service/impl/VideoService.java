package com.ambow.task10.service.impl;

import com.ambow.task10.pojo.Video;
import com.ambow.task10.service.IVideoService;

/**
 * 视频服务
 *
 * @author w
 * @date 2020/10/11
 */
public class VideoService implements IVideoService {

  private static final int MAX = 100;

  /** 视频 */
  private final Video[] videos = new Video[MAX];

  /** 视频数量 */
  private int size = 0;

  /** 打印所有 */
  public void printAll() {
    for (int i = 0; i < size; ++i) {
      System.out.println(videos[i]);
    }
  }

  /**
   * 按名称搜索
   *
   * @param name 名字
   */
  public void searchByName(String name) {
    for (int i = 0; i < size; ++i) {
      Video v = videos[i];
      if (v.getName().contains(name)) {
        System.out.println(v);
      }
    }
  }

  /**
   * 通过id查找视频
   *
   * @param id id
   * @return {@link Video}
   */
  public Video getById(long id) {
    for (int i = 0; i < size; ++i) {
      Video v = videos[i];
      if (v.getId() == id) {
        return v;
      }
    }
    return null;
  }

  /**
   * 添加视频
   *
   * @param id id
   * @param name 名字
   * @param actors 演员
   * @param content 简介
   */
  public void addVideo(long id, String name, String actors, String content) {
    if (size > MAX) {
      System.out.println("存储视频已经超出范围！");
      return;
    }
    videos[size++] = new Video(id, name, actors, content);
  }

  /**
   * 删除视频
   *
   * @param id id
   */
  public void deleteVideo(long id) {
    for (int i = 0; i < size; ++i) {
      Video v = videos[i];
      if (v.getId() == id) {

        // 使用数组复制来，移动数组
        if (i < size - 1) {
          System.arraycopy(videos, i + 1, videos, i, size - i);
        }

        videos[size - 1] = null;
        size--;
        break;
      }
    }
  }

  /**
   * 更新视频
   *
   * @param id id
   * @param name 的名字
   * @param actors 演员
   * @param content 内容
   */
  public void updateVideo(long id, String name, String actors, String content) {
    for (int i = 0; i < size; ++i) {
      Video v = videos[i];
      if (v.getId() == id) {
        v.setName(name);
        v.setActors(actors);
        v.setContent(content);
        System.out.println("修改后结果为：" + v);
        break;
      }
    }
  }
}
