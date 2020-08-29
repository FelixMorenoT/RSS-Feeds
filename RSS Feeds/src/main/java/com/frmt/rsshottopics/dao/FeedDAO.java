package com.frmt.rsshottopics.dao;

public class FeedDAO {
	private String feedTitle;

	private String feedLink;

	public FeedDAO(String feedTitle, String feedLink) {
		this.feedTitle = feedTitle;
		this.feedLink = feedLink;
	}

	public String getFeedTitle() {
		return feedTitle;
	}

	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}

	public String getFeedLink() {
		return feedLink;
	}

	public void setFeedLink(String feedLink) {
		this.feedLink = feedLink;
	}

	

}
