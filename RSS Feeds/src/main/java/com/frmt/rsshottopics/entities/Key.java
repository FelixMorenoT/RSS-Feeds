package com.frmt.rsshottopics.entities;

import java.io.Serializable;

public class Key implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idRequest;

	private Long idFeed;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.idRequest.equals(((Key) obj).getIdRequest()) && this.idFeed.equals(((Key) obj).getIdRequest());
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
