package ir.khoobi.jirasynchronizer.service;

import org.springframework.http.HttpHeaders;

public interface JiraAuthentication {


    public HttpHeaders getAuthenticatedHeader();

}
