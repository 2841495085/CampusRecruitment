package com.qdc.userconsumer;

import com.qdc.domain.Company;
import com.qdc.userconsumer.service.ConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserConsumerApplicationTests {

    @Autowired
    ConsumerService consumerService;

    @Test
    void contextLoads() {
        Company companyBycId = consumerService.findCompanyBycId(1002);
        System.out.println(companyBycId);
    }


}
