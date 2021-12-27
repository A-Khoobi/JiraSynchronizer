package ir.khoobi.jirasynchronizer.base.service;


import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseService<E extends BaseEntity<PK>, PK extends Serializable> {

    E save(E e);

    List<E> saveAll(Collection<E> collection);

    Optional<E> findById(PK id);

    List<E> findAll();

    Page<E> findAll(Pageable pageable);

    void deleteById(PK id);

}
