package com.frmt.rsshottopics.services;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.frmt.rsshottopics.dao.FeedDAO;
import com.frmt.rsshottopics.dao.TopicDAO;
import com.frmt.rsshottopics.entities.Feed;
import com.frmt.rsshottopics.entities.Topic;
import com.frmt.rsshottopics.repositories.FeedRepository;
import com.frmt.rsshottopics.repositories.TopicRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
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
	private String maxTopics;
	
	public void loadData(String idRequest, String url) throws IOException, FeedException {

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
	}
	
	public List<TopicDAO> getFeedByIdRequest(String idRequest) {
		List<Object[]> tempResult = topicRepository.getHotTopics(idRequest,maxTopics);
		List<Feed> tempFeeds = null;
		List<TopicDAO> listTopics = new ArrayList<>();

		for (Object[] objects : tempResult) {
			System.out.println(">>> " + objects[0].toString() + " - >>> " + objects[1].toString());
			TopicDAO tempTopic  =  new TopicDAO(objects[0].toString()); 
			
			tempFeeds = topicRepository.feedItems(objects[0].toString());
			
			tempTopic.setHotTopicFeeds(tempFeeds.stream().map(item -> {
				return new FeedDAO(item.getTitleFeed(), item.getLinkFeed());
			}).collect(Collectors.toList()));
			
			listTopics.add(tempTopic);
		}
		
		return listTopics;
	}
}
