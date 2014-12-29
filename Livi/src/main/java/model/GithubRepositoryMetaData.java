package model;

import util.Constant;

@SuppressWarnings("unused")
public class GithubRepositoryMetaData {
	private int rank;
	private String url;
	private String description;
	private int star;
	private int fork;
	private String lastUpdatedTime;
	
	public GithubRepositoryMetaData(int rank, String url, String description, String star, String fork, String lastUpdatedTime) {
		this.rank = rank;
		this.url = url;
		this.description = description;
		this.star = Integer.parseInt(star.replaceAll(Constant.NUMBER_SEPERATOR, ""));
		this.fork = Integer.parseInt(fork.replaceAll(Constant.NUMBER_SEPERATOR, ""));
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public int getRank() {
		return rank;
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
