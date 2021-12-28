package ir.khoobi.jirasynchronizer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import org.springframework.http.ResponseEntity;

public interface IssueService {


    ResponseEntity<Issue> generalIssueCreator(Issue issue) throws JsonProcessingException;
}
