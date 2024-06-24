package com.newong.hub.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class NewONGFranceResponse {

	private List<NewONGFranceResult> results; // returns a list of response from domain
}
