package com.ambow.task10.pojo;

/**
 * 视频
 *
 * @author w
 * @date 2020/10/11
 */
public class Video {
	
	public Video() {}

	public Video(long id, String name, String actors, String content) {
		this.id = id;
		this.name = name;
		this.actors = actors;
		this.content = content;
	}

	/** id */
	private long id;

	/** 名字 */
	private String name;

	/** 演员 */
	private String actors;

	/** 简介 */
	private String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "编号：" + id + "\t名称：" + name + "\t演员：" + actors + "\t简介：" + content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
