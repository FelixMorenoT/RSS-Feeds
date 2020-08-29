package com.frmt.rsshottopics.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frmt.rsshottopics.services.RSSServices;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Controller {
	
	final static Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private RSSServices services;
	
	@PostMapping("/analyse/new")
	public ResponseEntity<String> analyseNew(@RequestBody List<String> listUrls) {
		
		String idRequest = UUID.randomUUID().toString().replace("-", "");
		
		try {
			if(listUrls.size() < 2) {
				logger.error("Two url's are required");
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			
			for (String urlValue : listUrls) {
				services.loadData(idRequest, urlValue);
			}
			
			return new ResponseEntity<String>(idRequest,HttpStatus.OK);
		} catch (Exception e) {
			return null;
		}
	
	}
	
	@GetMapping("/frequency/{idRequest}")
	public String frecuency(@PathVariable("idRequest") String idRequest) {
		
			services.getFeedByIdRequest(idRequest);
		return "Testing";
	}
}
