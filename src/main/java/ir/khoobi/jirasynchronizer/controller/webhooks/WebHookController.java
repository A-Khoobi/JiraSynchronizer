package ir.khoobi.jirasynchronizer.controller.webhooks;


import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/sync")
public class WebHookController {

    //    /sync/issue
    @PostMapping("/issue")
    public ResponseEntity<Optional<Issue>> postIssue(HttpEntity<String> request) {

        return null;
    }


}
