package com.frmt.rsshottopics.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.frmt.rsshottopics.entities.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
	//JPQL	
	//SELECT t.feedName, count(*) as total  FROM Topic t WHERE t.feedElement.idRequest=:idRequest group by t.feedName order by total desc, t.feedName asc limit 3
	@Query(value="SELECT t.feed_Name, count(*) as total  FROM Topic t WHERE t.feed_Element_id_Request=:idRequest group by t.feed_Name order by total desc, t.feed_Name asc limit 3" ,
			nativeQuery = true)
	public List<Object[]> getHotTopics(@Param("idRequest") String idRequest);   
	
	/* 
	@Query("")
	List<Feed> feedItems();*/
}
