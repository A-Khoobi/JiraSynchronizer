package ir.khoobi.jirasynchronizer.model.JiraComponent;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;

import java.util.List;

public class JiraSearch extends BaseEntity<Long> {
    private List<Issue> issues;

    public JiraSearch(Long id) {
        super(id);
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

}
