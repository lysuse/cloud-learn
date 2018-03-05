package tech.youngstream.boot.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.youngstream.boot.template.dao.UserRepository;
import tech.youngstream.boot.template.domain.User;
import tech.youngstream.boot.template.service.UserService;

import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean save(String username, String password) {
        User user = new User(username, password);
        return userRepository.save(user) != null;
    }

    @Override
    public Stream<User> findAll() {
        return (Stream<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}