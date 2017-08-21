package com.Spring.City.sessionbean;

import com.Spring.City.service.CityServiceSession;
import com.Spring.City.service.impl.CityServiceSessionImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class SessionBean {
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CityServiceSession cityService(){
        return new CityServiceSessionImpl();
    }
}
