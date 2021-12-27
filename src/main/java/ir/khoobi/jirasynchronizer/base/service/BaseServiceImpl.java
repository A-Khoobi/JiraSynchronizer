package ir.khoobi.jirasynchronizer.base.service;

import ir.khoobi.jirasynchronizer.base.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<E extends BaseEntity<PK>, PK extends Serializable, R extends JpaRepository<E, PK>>
        implements BaseService<E, PK> {


    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }


    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public List<E> saveAll(Collection<E> collection) {
        return repository.saveAll(collection);
    }

    @Override
    public Optional<E> findById(PK id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteById(PK id) {
        repository.deleteById(id);
    }
}
