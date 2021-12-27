package ir.khoobi.jirasynchronizer.repository;

import ir.khoobi.jirasynchronizer.model.JiraComponent.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
