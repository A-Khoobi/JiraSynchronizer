package ir.khoobi.jirasynchronizer.base.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class BaseEntity<PK extends Serializable> implements Serializable {


    private PK id;

    public BaseEntity() {

    }


    public BaseEntity(PK id) {
        this.id = id;
    }

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
