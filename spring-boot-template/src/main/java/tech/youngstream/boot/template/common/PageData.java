package tech.youngstream.boot.template.common;

import lombok.Data;
import org.springframework.data.domain.Page;

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

    private long totalPages;

    private List<T> datas = Collections.emptyList();

    public static <T> PageData<T> fill(Page<T> page) {
        PageData<T> pageData = new PageData<>();
        pageData.setDatas(page.getContent());
        pageData.setPage(page.getNumber() + 1);
        pageData.setPageSize(page.getSize());
        pageData.setTotal(page.getTotalElements());
        pageData.setTotalPages(page.getTotalPages());
        return pageData;
    }

}
