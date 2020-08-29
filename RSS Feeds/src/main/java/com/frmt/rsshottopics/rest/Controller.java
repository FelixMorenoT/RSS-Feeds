package com.frmt.rsshottopics.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frmt.rsshottopics.dao.TopicDAO;
import com.frmt.rsshottopics.services.RSSServices;
import com.rometools.rome.io.FeedException;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class Controller {
	
	@Autowired
	private RSSServices services;
	
	@PostMapping("/analyse/new")
	public ResponseEntity<String> analyseNew(@RequestBody List<String> listUrls) throws IOException, FeedException{
		
		String idRequest = UUID.randomUUID().toString().replace("-", "");
		
			if(listUrls.size() < 2) {
				throw new com.frmt.rsshottopics.exception.FeedException("Two url's are required");
			}
			
			for (String urlValue : listUrls) {
				services.loadData(idRequest, urlValue);
			}
			
			return new ResponseEntity<String>(idRequest,HttpStatus.OK);
	} 
	
	@GetMapping("/frequency/{idRequest}")
	public ResponseEntity<List<TopicDAO>> frecuency(@PathVariable("idRequest") String idRequest) {
		List<TopicDAO> tempFeed = services.getFeedByIdRequest(idRequest);
		return new ResponseEntity<List<TopicDAO>>(tempFeed,HttpStatus.OK);
	}
}
