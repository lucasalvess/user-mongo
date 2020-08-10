package com.lucas.examplemongo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;


@Document(collation = "users")
@Getter
@Builder
@AllArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 2345425435345243L;

	private String name;
	
	private String email;
	
	private List<Address> addresses;
	
	@Default
    private Boolean deleted = Boolean.FALSE;
	
}
