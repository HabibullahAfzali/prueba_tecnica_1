package com.newong.hub.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.newong.hub.model.HubRequest;
import com.newong.hub.model.HubResponse;
import com.newong.hub.service.HubService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hub") // URI/ End point for accessing or calling api
@AllArgsConstructor
public class HubController {

	@Autowired
	private final HubService hubService;

	@PostMapping("/search")
	public HubResponse search(@RequestBody HubRequest request) throws JsonProcessingException {

		return hubService.search(request);
	}
}
