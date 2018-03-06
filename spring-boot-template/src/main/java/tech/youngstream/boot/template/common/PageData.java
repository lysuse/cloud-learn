package tech.youngstream.boot.template.common;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页数据
 * @param <T>
 */
@Data
public class PageData<T> {

    private int page;

    private int pageSize;

    private long total;

    private List<T> datas = Collections.emptyList();

}
