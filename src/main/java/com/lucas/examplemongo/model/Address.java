package com.lucas.examplemongo.model;

import javax.validation.constraints.Positive;

import com.lucas.examplemongo.model.enums.City;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	private City city;
	
	private String street;
	
	@Positive
	private Integer number;
}
