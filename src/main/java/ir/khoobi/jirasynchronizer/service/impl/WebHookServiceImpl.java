package ir.khoobi.jirasynchronizer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.model.JiraComponent.WebHookObject;
import ir.khoobi.jirasynchronizer.model.issuefields.IssueType;
import ir.khoobi.jirasynchronizer.model.issuefields.Project;
import ir.khoobi.jirasynchronizer.service.IssueService;
import ir.khoobi.jirasynchronizer.service.WebHookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class WebHookServiceImpl implements WebHookService {
    private final static String CREATE_ISSUE = "jira:issue_created";
    private final static String UPDATE_ISSUE = "jira:issue_updated";
    private final static String DELETE_ISSUE = "jira:issue_deleted";


    IssueService issueService;

    @Autowired
    public WebHookServiceImpl(IssueService issueService) {

        this.issueService = issueService;
    }

    @Override
    public ResponseEntity<Optional<Issue>> webHookDispatcher(HttpEntity<String> request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();


        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String body = request.getBody();
        WebHookObject webHookObject = mapper.readValue(body, WebHookObject.class);
        String actionType = webHookObject.getWebhookEvent();
        ResponseEntity<Issue> issue;
        switch (actionType) {
            case CREATE_ISSUE:
                issue = createIssue(webHookObject);
                break;
        }
        return null;
    }

    @Override
    public ResponseEntity<Issue> createIssue(WebHookObject webHookObject) throws JsonProcessingException {
        Issue issue = webHookObject.getIssue();
        issue.getFields().getComponents().clear();
//        issue.getFields().getComponents().add(new Component("11521"));
        issue.getFields().setSummary("test for jira connector final");
        issue.getFields().setProject(new Project("10000"));
        issue.getFields().setIssuetype(new IssueType("10003"));
        issue.getFields().setDescription("created from synchronize");
        issueService.generalIssueCreator(issue);

        return new ResponseEntity<Issue>(HttpStatus.CREATED);


    }
}
