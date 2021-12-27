package ir.khoobi.jirasynchronizer.model.issuefields;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;

public class Reporter extends BaseEntity<Long> {


    private String name;

    public Reporter(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Reporter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
