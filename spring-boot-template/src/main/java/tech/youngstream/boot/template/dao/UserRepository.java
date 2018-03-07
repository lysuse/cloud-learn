package tech.youngstream.boot.template.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tech.youngstream.boot.template.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

}
