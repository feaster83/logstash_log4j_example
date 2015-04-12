package nl.jasperhuzen.exampleapp;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@SuppressWarnings("unused")
public class ConfigureClientIDToMDC {
    @Autowired
    private Config config;

    @PostConstruct
    private void configureMDC() {
        MDC.put("client-id", config.getSystemUser() + "@" + config.getLocalhostName());
    }
}
