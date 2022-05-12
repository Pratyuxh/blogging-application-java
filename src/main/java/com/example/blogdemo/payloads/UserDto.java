package com.example.blogdemo.payloads;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;

    @NotEmpty
    @Size(min=4, message = "Username must be of minimum 4 characters")
    private String name;

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min=3, max=10, message = "Password must be minimum of 3 characters")
    private String password;

    @NotNull
    private String about;

}
