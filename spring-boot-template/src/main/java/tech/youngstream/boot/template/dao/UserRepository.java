package tech.youngstream.boot.template.dao;

import org.springframework.data.repository.CrudRepository;
import tech.youngstream.boot.template.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
