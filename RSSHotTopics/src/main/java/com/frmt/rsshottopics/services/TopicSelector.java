package com.frmt.rsshottopics.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class TopicSelector {

	public Set<String> extractAllTopics(String input) {
		
		String output = input.toLowerCase();
		
		Set<String> result = new HashSet<>();
		Collections.addAll(result, output.trim().split(" +"));
		return result;
	}
}
