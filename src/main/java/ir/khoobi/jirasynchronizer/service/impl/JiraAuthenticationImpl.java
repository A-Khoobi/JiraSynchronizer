package ir.khoobi.jirasynchronizer.service.impl;

import ir.khoobi.jirasynchronizer.service.JiraAuthentication;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


@Service
public class JiraAuthenticationImpl implements JiraAuthentication {

    @Value("${jira.destination.username}")
    private static String USERNAME;

    @Value("${jira.destination.password}")
    private static String PASSWORD;

    @Override
    public HttpHeaders getAuthenticatedHeader() {
        String credential = USERNAME + ":" + PASSWORD;
        byte[] credentialBytes = credential.getBytes();
        byte[] base64CredentialBytes = Base64.encodeBase64(credentialBytes);
        String base64Credential = new String(base64CredentialBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + base64Credential);
        return headers;
    }
}
