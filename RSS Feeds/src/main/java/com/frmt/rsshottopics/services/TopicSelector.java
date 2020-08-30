package com.frmt.rsshottopics.services;

import java.text.Normalizer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TopicSelector {

	@Value("${exclude}")
	private String toExclude; 
	
	public Set<String> extractAllTopics(String input) {
		
		String tempInput = input.toLowerCase();
		
		tempInput = stripAccents(tempInput);
		
		tempInput =tempInput.replaceAll("[^a-z0-9 ]", "").replace("  ", " ");
		
		for (String exclude : toExclude.split(",")) {
			tempInput = tempInput.replaceAll("\\b" + exclude + "\\b", "");
		}
				
		Set<String> result = new HashSet<>();
		Collections.addAll(result, tempInput.trim().split(" +"));
		
		return result;
	}
	
	private String stripAccents(String str) {
	
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);

	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
}
