package com.mfschool.spring.si.transform;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.castor.CastorMarshaller;

@Configuration
public class XmlConfiguration {

    @Bean
    public CastorMarshaller marshaller() {
        return new CastorMarshaller();
    }
}
