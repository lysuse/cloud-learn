package tech.youngstream.boot.template.service;

import tech.youngstream.boot.template.common.JsonResult;
import tech.youngstream.boot.template.common.PageData;
import tech.youngstream.boot.template.domain.User;
import tech.youngstream.boot.template.form.BasePageForm;

import java.util.stream.Stream;

public interface UserService {

    User save(String username, String password);

    Stream<User> findAll();

    User findById(Long id);

    boolean deleteById(Long id);

    JsonResult<PageData<User>> pages(BasePageForm pageForm);

    User update(User user);
}
