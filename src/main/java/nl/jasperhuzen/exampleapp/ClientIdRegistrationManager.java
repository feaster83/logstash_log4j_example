package nl.jasperhuzen.exampleapp;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@SuppressWarnings("unused")
public class ClientIdRegistrationManager {
    @Autowired
    private AppConfig appConfig;

    @PostConstruct
    private void configureMDC() {
        MDC.put("client-id", appConfig.getSystemUser() + "@" + appConfig.getLocalhostName());
    }
}
