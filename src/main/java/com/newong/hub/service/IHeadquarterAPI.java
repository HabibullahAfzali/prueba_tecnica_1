package com.newong.hub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.newong.hub.model.HubRequest;
import com.newong.hub.model.HubResponse;

public interface IHeadquarterAPI {
	HubResponse search(HubRequest request) throws JsonProcessingException;
}
