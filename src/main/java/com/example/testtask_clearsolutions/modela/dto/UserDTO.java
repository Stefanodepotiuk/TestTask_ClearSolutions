package com.example.testtask_clearsolutions.modela.dto;

import com.example.testtask_clearsolutions.modela.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private LocalDate birthDay;
    private String address;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
        this.birthDay = user.getBirthDay();
        this.address = user.getAddress();
    }


}
