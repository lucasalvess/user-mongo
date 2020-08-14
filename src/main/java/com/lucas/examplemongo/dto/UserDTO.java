package com.lucas.examplemongo.dto;

import com.lucas.examplemongo.model.Address;
import com.lucas.examplemongo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

		List<AddressDTO> addressDTOList = new ArrayList<>();

		for (Address address:user.getAddresses()) {
			addressDTOList.add(new AddressDTO(address));
		}

		this.addresses = addressDTOList;

	}

}
