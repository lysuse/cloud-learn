package tech.youngstream.boot.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.youngstream.boot.template.common.JsonResult;
import tech.youngstream.boot.template.common.PageData;
import tech.youngstream.boot.template.dao.UserRepository;
import tech.youngstream.boot.template.domain.User;
import tech.youngstream.boot.template.form.BasePageForm;
import tech.youngstream.boot.template.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final Random random = new Random();

    @Override
    @Transactional
    public User save(String username, String password) {
        User user = new User(username, password);
        User savedUser = userRepository.save(user);
        if(savedUser == null || random.nextBoolean()) {
            throw new IllegalArgumentException("No Password!");
        }
        return savedUser;
    }

    @Override
    public Stream<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll()
                .forEach(single ->{list.add(single);});
        return list.stream();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public JsonResult<PageData<User>> pages(BasePageForm pageForm) {
        Page<User> page = userRepository.findAll(PageRequest.of(pageForm.getPage() - 1, pageForm.getPageSize(), Sort.Direction.DESC, "createdDate"));
        return JsonResult.success(PageData.fill(page));
    }

    @Override
    @Transactional
    public User update(User user) {
        user.setCreatedDate(userRepository.findById(user.getId()).get().getCreatedDate());
        return userRepository.save(user);
    }
}
