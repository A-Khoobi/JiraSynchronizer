package ir.khoobi.jirasynchronizer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.service.IssueService;
import ir.khoobi.jirasynchronizer.service.JiraAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IssueServiceImpl implements IssueService {


    public static final String createApi = "/rest/api/2/issue";

    //    @Value("${jira.destination.url}")
//    public static String destinationUrl;
    @Value("${jira.destination.url}")
    public String destinationUrl;

    JiraAuthentication jiraAuthentication;

    @Autowired
    public IssueServiceImpl(JiraAuthentication jiraAuthentication) {
        this.jiraAuthentication = jiraAuthentication;
    }

    @Override
    public ResponseEntity<Issue> generalIssueCreator(Issue issue) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = destinationUrl + createApi;
        System.out.println(requestUrl);
        HttpHeaders headers = jiraAuthentication.getAuthenticatedHeader();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.writer().withoutAttribute("key");
        String jasonIssue = mapper.writeValueAsString(issue);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(jasonIssue, headers);

        ResponseEntity<Issue> issueResponseEntity = restTemplate.exchange(requestUrl, HttpMethod.POST, request, Issue.class);

        return issueResponseEntity;
    }
}
