package ir.khoobi.jirasynchronizer.controller.webhooks;


import com.fasterxml.jackson.core.JsonProcessingException;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.service.WebHookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sync")
public class WebHookController {


    WebHookService webHookService;

    @Autowired
    public WebHookController(WebHookService webHookService) {
        this.webHookService = webHookService;
    }

    //    /sync/issue
    @PostMapping("/issue")
    public ResponseEntity<Optional<Issue>> postIssue(HttpEntity<String> request) throws JsonProcessingException {
        webHookService.webHookDispatcher(request);

        return null;
    }


}
