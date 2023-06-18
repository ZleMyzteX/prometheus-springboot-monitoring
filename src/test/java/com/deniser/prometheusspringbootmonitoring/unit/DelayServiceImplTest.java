package com.deniser.prometheusspringbootmonitoring.unit;

import com.deniser.prometheusspringbootmonitoring.service.DelayServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest()
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
class DelayServiceImplTest {

    @Autowired
    private DelayServiceImpl delayService;

}