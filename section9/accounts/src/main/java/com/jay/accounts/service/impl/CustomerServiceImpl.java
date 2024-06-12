package com.jay.accounts.service.impl;

import com.jay.accounts.dto.AccountsDto;
import com.jay.accounts.dto.CardsDto;
import com.jay.accounts.dto.CustomerDetailsDto;
import com.jay.accounts.dto.LoansDto;
import com.jay.accounts.entity.Accounts;
import com.jay.accounts.entity.Customer;
import com.jay.accounts.exception.ResourceNotFoundException;
import com.jay.accounts.mapper.AccountsMapper;
import com.jay.accounts.mapper.CustomerMapper;
import com.jay.accounts.repository.AccountsRepository;
import com.jay.accounts.repository.CustomerRepository;
import com.jay.accounts.service.ICustomerService;
import com.jay.accounts.service.client.CardsFeignClient;
import com.jay.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;


    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "MobileNumber", mobileNumber)
        );

        Accounts accounts =  accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts", "CustomerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
