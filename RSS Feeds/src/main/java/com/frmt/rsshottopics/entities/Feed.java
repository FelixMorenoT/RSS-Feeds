package com.frmt.rsshottopics.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@IdClass(Key.class)
public class Feed {

	@Id
	@Column(name = "id_request")
	private String idRequest;
	
	@Id
	@GeneratedValue()
	@Column(name = "id_feed")
	private Long idFeed;
	
	@Column(name = "title_feed",length=2048)
	private String titleFeed;
	
	@Column(name = "link_feed", length=2048)
	private String linkFeed;
	
	@Column(name = "list_topics")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "feed_element_id_request", referencedColumnName = "id_request")
	@JoinColumn(name = "feed_element_id_feed", referencedColumnName = "id_feed")
	private List<Topic> listTopics;

	public Feed() {
	
	}
	
	public Feed(String idRequest, String titleFeed, String linkFeed) {
		this.idRequest = idRequest;
		this.titleFeed = titleFeed;
		this.linkFeed = linkFeed;
	}

	public String getIdRequest() {
		return idRequest;
	}

	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	public Long getIdFeed() {
		return idFeed;
	}

	public void setIdFeed(Long idFeed) {
		this.idFeed = idFeed;
	}

	public String getTitleFeed() {
		return titleFeed;
	}

	public void setTitleFeed(String titleFeed) {
		this.titleFeed = titleFeed;
	}

	public String getLinkFeed() {
		return linkFeed;
	}

	public void setLinkFeed(String linkFeed) {
		this.linkFeed = linkFeed;
	}

	public List<Topic> getListTopics() {
		return listTopics;
	}

	public void setListTopics(List<Topic> listTopics) {
		this.listTopics = listTopics;
	}	
}
