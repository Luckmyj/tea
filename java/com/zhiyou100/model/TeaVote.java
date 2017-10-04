package com.zhiyou100.model;

public class TeaVote {
	
	private Integer id;
	
	private String name;
	
	private String image;
	
	private Integer vote;

	public TeaVote() {
		super();
	}

	public TeaVote(Integer id, String name, String image, Integer vote) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.vote = vote;
	}
	
	@Override
	public String toString() {
		return "TeaVote [id=" + id + ", name=" + name + ", image=" + image + ", vote=" + vote + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
