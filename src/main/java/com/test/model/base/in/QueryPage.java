package com.test.model.base.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lu.feng
 */
@Data
public class QueryPage implements Serializable {

    private static final long serialVersionUID = -3779625701232577102L;
    /**
     * 第几页
     */
    @JsonProperty("PageIndex")
    private int pageIndex = 1;

    /**
     * 每页多少条数据
     */
    @JsonProperty("PageSize")
    private int pageSize = 10;
}
