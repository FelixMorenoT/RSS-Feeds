package com.frmt.rsshottopics.dao;

import java.util.List;


public class TopicDAO {
	
	private String hotTopicName;
	private List<FeedDAO> hotTopicFeeds;
	
	public TopicDAO(String hotTopicName) {
		this.hotTopicName = hotTopicName;
	}

	public String getHotTopicName() {
		return hotTopicName;
	}

	public void setHotTopicName(String hotTopicName) {
		this.hotTopicName = hotTopicName;
	}

	public List<FeedDAO> getHotTopicFeeds() {
		return hotTopicFeeds;
	}

	public void setHotTopicFeeds(List<FeedDAO> hotTopicFeeds) {
		this.hotTopicFeeds = hotTopicFeeds;
	}
	



}
