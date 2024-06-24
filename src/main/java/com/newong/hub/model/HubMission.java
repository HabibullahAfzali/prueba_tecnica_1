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

public class HubMission {

	private int missionId;
	private List<HubVolunteer> volunteers  = new ArrayList<>();

	public HubMission(int missionId) {
		this.missionId = missionId;
	}
	// Add new volunteer for mission
	public void addVolunteer(HubVolunteer volunteer) {
		this.volunteers.add(volunteer);
	}
}
