package com.newong.hub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.newong.hub.model.HubRequest;
import com.newong.hub.model.HubResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HubService {

	private List<IHeadquarterAPI> headquarterAPIS;
	public HubResponse search(HubRequest request) throws JsonProcessingException {
		HubResponse aggregatedResponse = new HubResponse();

		for (IHeadquarterAPI headquarter : headquarterAPIS) {
			HubResponse response = headquarter.search(request);
			aggregatedResponse.merge(response);
		} // the HQ and calls to it

		return aggregatedResponse;
	}
}
