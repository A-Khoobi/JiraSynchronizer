package ir.khoobi.jirasynchronizer.service;

import ir.khoobi.jirasynchronizer.base.service.BaseService;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;

public interface IssueService extends BaseService<Issue, Long> {


    Issue generalIssueCreator(Issue issue);
}
