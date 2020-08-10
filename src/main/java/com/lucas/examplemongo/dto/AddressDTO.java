package com.lucas.examplemongo.dto;

import com.lucas.examplemongo.model.Address;
import com.lucas.examplemongo.model.enums.City;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private City city;
    private String street;
    private Integer number;

    public AddressDTO(Address address){
        this.city = address.getCity();
        this.number = address.getNumber();
        this.street = address.getStreet();
    }
}
