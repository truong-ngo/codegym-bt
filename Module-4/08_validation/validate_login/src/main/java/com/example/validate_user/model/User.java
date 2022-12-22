package com.example.validate_user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class User implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]*$)")
    private String phoneNumber;
    @Min(18)
    private Integer age;
    @NotEmpty
    @Email
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String firstName = user.firstName;
        String lastName = user.lastName;
        if (!firstName.matches("^([a-zA-Z]+)$")) {
            errors.rejectValue("firstName", "firstName.format");
        }
        if (!lastName.matches("^([a-zA-Z]+)$")) {
            errors.rejectValue("lastName", "lastName.format");
        }

    }
}
