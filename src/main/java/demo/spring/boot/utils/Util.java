package demo.spring.boot.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
public class Util {

    private Util() {}

    public static String getHostname() {
        String hostname;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "UnknownHost";
            log.error("Unable to get hostname due to: ", e);
        }

        return hostname;
    }

    public static String getHostAddress() {
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            hostAddress = "UnknownHostAddress";
            log.error("Unable to get host address due to: ", e);
        }

        return hostAddress;
    }
}
