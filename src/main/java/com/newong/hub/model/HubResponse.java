package com.newong.hub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HubResponse {

	private List<HubMission> country = new ArrayList<>(); // Initialize the list of countries

	public void addVolunteer(int missionId, String name, int age, String HQ) {
		// Check if the mission with missionId exists in the country
		HubMission mission = country.stream()
				.filter(m -> m.getMissionId() == missionId)
				.findFirst()
				.orElseGet(() -> {
					// If mission does not exist, create a new mission with missionId
					HubMission newMission = new HubMission(missionId);
					country.add(newMission); // Add new mission to the country
					return newMission; // Return the newly created mission
				});

		// Add the volunteer to the mission
		mission.addVolunteer(new HubVolunteer(name, age, HQ));
	}
	public void merge(HubResponse other) {
		// Iterate through each mission in the other HubResponse
		for (HubMission mission : other.getCountry()) {
			// Iterate through each volunteer in the mission
			for (HubVolunteer volunteer : mission.getVolunteers()) {
				// Add the volunteer to this HubResponse using addVolunteer()
				addVolunteer(mission.getMissionId(), volunteer.getName(), volunteer.getAge(), volunteer.getHQ());
			}
		}
	}
}
