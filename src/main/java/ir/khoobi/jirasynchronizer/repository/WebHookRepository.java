package ir.khoobi.jirasynchronizer.repository;

import ir.khoobi.jirasynchronizer.model.JiraComponent.WebHookObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebHookRepository extends JpaRepository<WebHookObject, Long> {
}
