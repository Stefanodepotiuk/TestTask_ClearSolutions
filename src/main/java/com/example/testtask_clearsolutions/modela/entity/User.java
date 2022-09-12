package com.example.testtask_clearsolutions.modela;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
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


}
