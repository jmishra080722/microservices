package com.jay.accounts.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "Name can not be blank or null")
    @Size(min = 5, max = 30, message = "The length of the customer name should be in between 5 and 30")
    private String name;

    @NotEmpty(message = "Email can not be null or blank")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;
}
