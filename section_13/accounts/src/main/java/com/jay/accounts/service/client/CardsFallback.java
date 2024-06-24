package com.jay.accounts.service.client;

import com.jay.accounts.dto.CardsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient {

    @Override
    public ResponseEntity<CardsDto> fetchCardDetails(String correlationId, String mobileNumber) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new CardsDto());
    }
}
