package com.lucas.examplemongo.dto;

import com.lucas.examplemongo.model.Address;
import com.lucas.examplemongo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

	private String id;
    private String name;
	private String email;
	private List<AddressDTO> addresses;

	public UserDTO(User user){
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
     	user.getAddresses().stream()
				.map(address -> this.addresses.add(new AddressDTO(address)))
				.collect(Collectors.toList());
	}

}
