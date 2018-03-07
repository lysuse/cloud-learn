package tech.youngstream.boot.template.form;

import lombok.Data;

@Data
public class BasePageForm {

    protected int page = 1;

    protected int pageSize  = 5;
}
