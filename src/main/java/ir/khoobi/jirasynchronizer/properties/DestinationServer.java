package ir.khoobi.jirasynchronizer.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jira.destination")
@EnableConfigurationProperties
public class DestinationServer {

    public String url;

    public String username;

    public String passWord;

}
