package ir.khoobi.jirasynchronizer.model.JiraComponent;

public class WebHookObject {

    private String webhookEvent;

    private Issue issue;

    public WebHookObject() {
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
