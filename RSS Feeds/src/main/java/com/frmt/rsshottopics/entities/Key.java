package com.frmt.rsshottopics.entities;

import java.io.Serializable;

public class Key implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idRequest;

	private Long idFeed;
 
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
