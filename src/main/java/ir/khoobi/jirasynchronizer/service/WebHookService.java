package ir.khoobi.jirasynchronizer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.model.JiraComponent.WebHookObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface WebHookService {

    ResponseEntity<Optional<Issue>> webHookDispatcher(HttpEntity<String> request) throws JsonProcessingException;

    ResponseEntity<Issue> createIssue(WebHookObject webHookObject) throws JsonProcessingException;


}
