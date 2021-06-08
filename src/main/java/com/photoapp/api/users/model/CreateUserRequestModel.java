package com.photoapp.api.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

    @NotNull(message = "First name should not be null")
    @Size(min = 2, message = "First name should be at least two numbers")
    private String firstName;
    @NotNull(message = "Second name should not be null")
    @Size(min = 2, message = "Second name should be at least two numbers")
    private String lastName;
    @NotNull(message = "Password should not be null")
    @Size(min = 8, max = 16, message = "Password should be equal or great than 8 characters but not bigger than 16 chars")
    private String password;
    @NotNull(message = "Email should not be null")
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
