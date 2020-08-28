package com.frmt.rsshottopics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frmt.rsshottopics.entities.Feed;

@Repository
public interface FeedRepository  extends JpaRepository<Feed, Long>{

}
