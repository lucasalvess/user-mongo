package com.lucas.examplemongo.resource.form;

import com.lucas.examplemongo.model.Address;
import com.lucas.examplemongo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserForm implements Serializable {

    private String name;
    private String email;
    private List<Address> addresses;

    public User toUser(){
        return User.builder()
                .addresses(this.addresses)
                .email(this.email)
                .name(this.name)
                .build();
    }
}
