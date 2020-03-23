package com.lucas.examplemongo.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 2345425435345243L;

	private String nome;
	
	private String email;
	
	private List<Endereco> endereco;
	
}
