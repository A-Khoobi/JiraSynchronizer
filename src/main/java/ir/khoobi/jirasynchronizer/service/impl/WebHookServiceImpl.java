package ir.khoobi.jirasynchronizer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.khoobi.jirasynchronizer.base.service.BaseServiceImpl;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.model.JiraComponent.WebHookObject;
import ir.khoobi.jirasynchronizer.repository.WebHookRepository;
import ir.khoobi.jirasynchronizer.service.WebHookService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class WebHookServiceImpl extends BaseServiceImpl<WebHookObject, Long, WebHookRepository> implements WebHookService {
    private final static String CREATE_ISSUE = "jira:issue_created";
    private final static String UPDATE_ISSUE = "jira:issue_updated";
    private final static String DELETE_ISSUE = "jira:issue_deleted";

    public WebHookServiceImpl(WebHookRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Optional<Issue>> webHookDispatcher(HttpEntity<String> request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WebHookObject webHookObject = mapper.readValue(request.getBody(), WebHookObject.class);
        String actionType = webHookObject.getWebhookEvent();
        ResponseEntity<Optional<Issue>> issue;
        switch (actionType) {
            case CREATE_ISSUE:
                issue = createIssue(webHookObject);
                break;
        }
        return null;
    }

    @Override
    public ResponseEntity<Optional<Issue>> createIssue(WebHookObject webHookObject) {
        Issue sourceIssue = webHookObject.getIssue();
        Issue newIssue;


    }
}
