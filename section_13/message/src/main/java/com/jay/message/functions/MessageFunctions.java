package com.jay.message.functions;

import com.jay.message.dto.AccountsMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger logger = LoggerFactory.getLogger(MessageFunctions.class);

    public Function<AccountsMsgDto, AccountsMsgDto> email(){
        return accountsMsgDto -> {
            logger.info("Sending email with the details: "+accountsMsgDto);
            return accountsMsgDto;
        };
    }

    public Function<AccountsMsgDto, Long> sms(){
        return accountsMsgDto -> {
            logger.info("Sending sms with the details: +accountsMsgDto");
            return accountsMsgDto.accountNumber();
        };
    }
}
