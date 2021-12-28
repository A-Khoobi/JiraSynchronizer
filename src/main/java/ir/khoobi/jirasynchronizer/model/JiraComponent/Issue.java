package ir.khoobi.jirasynchronizer.model.JiraComponent;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;


public class Issue extends BaseEntity<Long> {

    private Fields fields;

    public Issue(Long id) {
        super(id);
    }

    public Issue() {

    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

}
