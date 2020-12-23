package com.ambow.task10.service;

import com.ambow.task10.pojo.Video;

public interface IVideoService {

	void printAll();

	void searchByName(String name);

	Video getById(long id);

	void addVideo(long id, String name, String actors, String content);

	void deleteVideo(long id);

	void updateVideo(long id, String name, String actors, String content);

}
