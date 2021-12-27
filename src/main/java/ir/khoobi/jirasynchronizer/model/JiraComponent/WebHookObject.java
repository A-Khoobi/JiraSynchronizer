package ir.khoobi.jirasynchronizer.model.JiraComponent;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;

public class WebHookObject extends BaseEntity<Long> {

    private String webhookEvent;
    private Issue issue;

    public WebHookObject(Long id) {
        super(id);
    }


    public WebHookObject(Issue issue) {
        this.issue = issue;
    }

    public String getWebhookEvent() {
        return webhookEvent;
    }

    public void setWebhookEvent(String webhookEvent) {
        this.webhookEvent = webhookEvent;
    }

    public Issue getIssue() {
        return issue;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
    }
}
