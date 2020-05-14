package com.bortnichuk.config;

import com.bortnichuk.dao.WindowDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public WindowDao getWindowDao(){
        return new WindowDao();
    }

}
