package com.lucas.examplemongo.model;

import java.io.Serializable;
import java.util.List;


import com.lucas.examplemongo.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder.Default;


@Document(collation = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 2345425435345243L;

	@Id
	private String id;

	private String name;
	
	private String email;

	private List<Address> addresses;
	
	@Default
    private Boolean deleted = Boolean.FALSE;

}
