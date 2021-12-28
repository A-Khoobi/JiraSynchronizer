package ir.khoobi.jirasynchronizer.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jira.source")
public class SourceServer {

    public String url;

    public String username;

    public String password;


}
