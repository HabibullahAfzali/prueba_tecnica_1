package com.newong.hub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // Generate constructor whenever needed
@NoArgsConstructor // when we don't implement it automatically remove the usage
@Getter // Generate getter
@Setter // Generate setter
public class NewONGFranceResult {
	private int mission;
	private String name;
	private int age;
	@JsonProperty("HQ") // Correct convert the Json format on the converting implementation on NewONGFrance class
	private String HQ;
}
