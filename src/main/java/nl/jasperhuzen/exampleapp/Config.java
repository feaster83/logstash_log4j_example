package nl.jasperhuzen.exampleapp;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Getter
@Component
public class Config {

    @Value("#{environment.USER}")
    private String systemUser;

    private String localhostName;

    @PostConstruct
    private void initialize() throws UnknownHostException {
        localhostName = InetAddress.getLocalHost().getHostName();
    }
}
