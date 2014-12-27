package model;

import util.Constant;

public class GithubRepositoryMetaData {
	private String url;
	private String description;
	private int star;
	private int fork;
	private String lastUpdatedTime;
	
	public GithubRepositoryMetaData(String url, String description, String star, String fork, String lastUpdatedTime) {
		this.url = Constant.GITHUB_URL + url;
		this.description = description;
		this.star = Integer.parseInt(star.replaceAll(Constant.NUMBER_SEPERATOR, ""));
		this.fork = Integer.parseInt(fork.replaceAll(Constant.NUMBER_SEPERATOR, ""));
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	public String getUrl() {
		return url;
	}
	public String getDescription() {
		return description;
	}
	public int getStar() {
		return star;
	}
	public int getFork() {
		return fork;
	}
	
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
}
