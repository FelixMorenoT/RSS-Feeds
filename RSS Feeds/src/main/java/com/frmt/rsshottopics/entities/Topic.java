package com.frmt.rsshottopics.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Topic {

	@Id
	@GeneratedValue()
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Feed feedElement;

	@Column(name = "feed_name")
	private String feedName;

	public Topic() {
		
	}
	
	public Topic(String feedName) {
		this.feedName = feedName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Feed getFeedElement() {
		return feedElement;
	}

	public void setFeedElement(Feed feedElement) {
		this.feedElement = feedElement;
	}

	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}
}
