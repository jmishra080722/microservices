package com.jay.accounts.service;

import com.jay.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId);
}
