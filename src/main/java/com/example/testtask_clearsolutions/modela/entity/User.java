package com.example.testtask_clearsolutions.modela.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "First name cannot be empty ")
    @Size(min = 2, message = "First name cannot have less than 2 symbol")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty ")
    @Size(min = 2, message = "Last name cannot have less than 2 symbol")
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "invalid email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$;", message = "invalid mobile number entered")
    private String mobile;

    @NotBlank(message = "This field cannot empty")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    private String address;

    private LocalDate currentDate = LocalDate.now();

    public User(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.mobile = user.getMobile();
        this.birthDay = user.getBirthDay();
        this.address = user.getAddress();
    }
}
