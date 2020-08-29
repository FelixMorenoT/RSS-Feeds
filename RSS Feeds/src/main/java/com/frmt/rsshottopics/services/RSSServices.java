package com.frmt.rsshottopics.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.frmt.rsshottopics.entities.Feed;
import com.frmt.rsshottopics.entities.Topic;
import com.frmt.rsshottopics.repositories.FeedRepository;
import com.frmt.rsshottopics.repositories.TopicRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class RSSServices {

	@Autowired
	private FeedRepository feedRepository;
	
	@Autowired
	private TopicRepository	topicRepository;
	
	@Autowired
	private TopicSelector topicSelector;
	
	@Value("${maxtopics}")
	private Integer maxTopics;
	
	public void loadData(String idRequest, String url) {

		try {
			SyndFeed feedHandler = new SyndFeedInput().build(new XmlReader(new URL(url)));
			List<SyndEntry> listFeed = feedHandler.getEntries();
			
			for (SyndEntry syndEntry : listFeed) {
				Feed tempFedd = new Feed(idRequest, syndEntry.getTitle(), syndEntry.getLink());
				List<Topic> tempListTopic = new ArrayList<Topic>();
				
				Set<String> topicNames = topicSelector.extractAllTopics(syndEntry.getTitle());
				
				for (String name : topicNames) {
					Topic topic = new Topic(name);
					tempListTopic.add(topic);
				}
				tempFedd.setListTopics(tempListTopic);
				feedRepository.save(tempFedd);
			}

		} catch (Exception e) {
			System.out.println("ERRRO "  + e);
		} 
	}
	
	public void getFeedByIdRequest(String idRequest) {
		List<Object[]> tempResult = topicRepository.getHotTopics(idRequest);

		for (Object[] objects : tempResult) {
			System.out.println(">>> " + objects[0]);
		}
		
	
	}
}
