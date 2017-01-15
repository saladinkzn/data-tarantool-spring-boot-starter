package ru.shadam.spring.boot.tarantool;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sala
 */
@ConfigurationProperties(prefix = "ru.shadam.tarantool")
public class TarantoolProperties {
    private String host = "localhost";
    private int port = 3301;

    private String username = "guest";
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
