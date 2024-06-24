package com.newong.hub.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newong.hub.model.HubRequest;
import com.newong.hub.model.HubResponse;
import com.newong.hub.model.NewONGFranceResponse;
import com.newong.hub.model.NewONGFranceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // This annotation indicate that it belongs ot service layer
public class NewONGFrance implements IHeadquarterAPI {

	@Autowired // use for dependency injection
	private ObjectMapper objectMapper;
	@Override
	public HubResponse search(HubRequest request) throws JsonProcessingException {
		// RAW/ Hardcoded json response from NewONG_France
		String jsonResponse = """
            {
                "results": [
                    {
                        "mission": 1,
                        "name": "Gerard",
                        "age": 28,
                        "HQ": "NewONG_France"
                    },
                    {
                        "mission": 2,
                        "name": "Gerard",
                        "age": 28,
                        "HQ": "NewONG_France"
                    }
                ]
            }
        """;
		// Debug to check the json response
		System.out.println("Json Response: " +jsonResponse);
		// Convert the response to HubResponse format
		return translateResponse(jsonResponse);
	}

	private HubResponse translateResponse(String jsonResponse) throws JsonProcessingException {
		// Think that we have a JSON parser to convert JSON strings to objects
		NewONGFranceResponse franceResponse = objectMapper.readValue(jsonResponse, NewONGFranceResponse.class);

		// Debug: Print the parsed response
		System.out.println("Parsed Response: " + franceResponse);

		HubResponse hubResponse = new HubResponse();
		for (NewONGFranceResult result : franceResponse.getResults()) {
			// Debug: Print each result
			System.out.println("Result: Mission=" + result.getMission() +
					", Name=" + result.getName() + ", Age="
					+ result.getAge() + ", HQ=" + result.getHQ());

			hubResponse.addVolunteer(result.getMission(),
					result.getName(), result.getAge(), result.getHQ());
		}
		return hubResponse;
	}

}
