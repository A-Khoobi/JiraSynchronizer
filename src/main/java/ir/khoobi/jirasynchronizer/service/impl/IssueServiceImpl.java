package ir.khoobi.jirasynchronizer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.khoobi.jirasynchronizer.base.service.BaseServiceImpl;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.repository.IssueRepository;
import ir.khoobi.jirasynchronizer.service.IssueService;
import ir.khoobi.jirasynchronizer.service.JiraAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IssueServiceImpl extends BaseServiceImpl<Issue, Long, IssueRepository> implements IssueService {
    public IssueServiceImpl(IssueRepository repository) {
        super(repository);
    }

    public static final String createApi = "/rest/api/2/issue";
    @Value("${<jira.destination.url>}")
    public static String destinationUrl;
    RestTemplate restTemplate;
    JiraAuthentication jiraAuthentication;

    @Autowired
    public IssueServiceImpl(IssueRepository repository, JiraAuthentication jiraAuthentication) {
        super(repository);
        this.jiraAuthentication = jiraAuthentication;
    }

    @Override
    public ResponseEntity<Issue> generalIssueCreator(Issue issue) throws JsonProcessingException {

        String requestUrl = destinationUrl + createApi;
        HttpHeaders headers = jiraAuthentication.getAuthenticatedHeader();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jasonIssue = mapper.writeValueAsString(issue);
        HttpEntity<String> request = new HttpEntity<String>(jasonIssue, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Issue> issueResponseEntity = restTemplate.exchange(requestUrl, HttpMethod.POST, request, Issue.class);

        return issueResponseEntity;
    }
}
