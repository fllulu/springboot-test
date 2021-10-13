package com.test.model.base.out;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lu.feng
 */
@Data
@NoArgsConstructor
public class PageVO<T> implements Serializable {

    private static final long serialVersionUID = -7499989607438536616L;
    /**
     * 起始数
     */
    private Integer pageIndex;

    /**
     * 单页条数
     */
    private Integer pageSize;

    /**
     * 总条数
     */
    private Long count;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 结果集
     */
    private List<T> rows;


    public PageVO(Long count, List<T> results) {
        this.count = count;
        this.rows = results;
    }

    public PageVO(Long count, Integer totalPage, List<T> results) {
        this.count = count;
        this.rows = results;
        this.totalPage = totalPage;
    }

    public static <T> PageVO<T> getPageVo(Long totalCount, List<T> results) {
        return new PageVO<>(totalCount, results);
    }

    public static <T> PageVO<T> getPageVo(Long totalCount, Integer totalPage, List<T> results) {
        return new PageVO<>(totalCount, totalPage, results);
    }

}
