package com.test.mapper.base;

import com.test.entity.base.BaseBean;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T extends BaseBean> extends Mapper<T>, MySqlMapper<T>/*, BatchUpdateMapper<T>*/ {

	
}

