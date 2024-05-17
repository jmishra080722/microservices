package com.jay.accounts.service;

import com.jay.accounts.dto.AccountsDto;
import com.jay.accounts.dto.CustomerDto;

public interface IAccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);


}
