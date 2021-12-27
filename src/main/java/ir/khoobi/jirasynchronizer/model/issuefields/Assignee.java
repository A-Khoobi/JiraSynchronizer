package ir.khoobi.jirasynchronizer.model.issuefields;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;

public class Assignee extends BaseEntity<Long> {

    private String name;

    public Assignee(Long id) {
        super(id);
    }


    public Assignee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
