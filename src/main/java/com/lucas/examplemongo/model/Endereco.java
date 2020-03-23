package com.lucas.examplemongo.model;

import javax.validation.constraints.Positive;

import com.lucas.examplemongo.model.enums.Municipio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
	
	private Municipio municipo;
	
	private String rua;
	
	@Positive
	private Integer numero;
}
