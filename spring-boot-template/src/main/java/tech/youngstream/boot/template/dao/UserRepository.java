package tech.youngstream.boot.template.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tech.youngstream.boot.template.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    /**
     * 自定义查找
     * @param username
     * @param password
     * @return
     */
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    User findByCustomer(String username, String password);

}
