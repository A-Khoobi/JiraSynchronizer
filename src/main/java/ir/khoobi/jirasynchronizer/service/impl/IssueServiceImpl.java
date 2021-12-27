package ir.khoobi.jirasynchronizer.service.impl;

import ir.khoobi.jirasynchronizer.base.service.BaseServiceImpl;
import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import ir.khoobi.jirasynchronizer.repository.IssueRepository;
import ir.khoobi.jirasynchronizer.service.IssueService;

public class IssueServiceImpl extends BaseServiceImpl<Issue, Long, IssueRepository> implements IssueService {
    public IssueServiceImpl(IssueRepository repository) {
        super(repository);
    }


    @Override
    public Issue generalIssueCreator(Issue issue) {

        return null;
    }
}
