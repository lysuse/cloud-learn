package tech.youngstream.boot.template.service;

import tech.youngstream.boot.template.domain.User;

import java.util.stream.Stream;

public interface UserService {

    boolean save(String username, String password);

    Stream<User> findAll();

    User findById(Long id);

}
