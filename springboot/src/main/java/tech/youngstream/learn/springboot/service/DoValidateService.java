package tech.youngstream.learn.springboot.service;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;

/**
 * 参数可以被校验的service
 */
@Service
@Validated
public class DoValidateService {


    public String findByCodeAndAuthor(@Size(min = 8, max = 10) String code,
                                      @NotBlank String author) {

        return String.format("%s 's book code is %s!", author, code);
    }

}
