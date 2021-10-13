package com.test.dao.base;


import com.test.entity.base.BaseBean;
import com.test.mapper.base.BaseMapper;
import com.test.utils.NullUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;


public abstract class BaseDao<T extends BaseBean> {
	
	@Autowired
    protected BaseMapper<T> baseMapper;


    /**
     * 查询总数据数
     *
     * @return 总数据数
     */
    @Transactional(readOnly = true)
    public Integer selectCount() {
        return this.baseMapper.selectCount(null);
    }


    /**
     * 根据条件查询总数据数
     *
     * @param record 记录
     * @return 总数据数
     */
    @Transactional(readOnly = true)
    public Integer selectCountByWhere(T record) {
        return this.baseMapper.selectCount(record);
    }


    /**
     * 根据id查询数据
     *
     * @param id 主键
     * @return 记录
     */
    @Transactional(readOnly = true)
    @Deprecated
    public T selectByPrimaryKey(Serializable id) {
        return this.baseMapper.selectByPrimaryKey(id);
    }


    /**
     * 查询所有数据
     *
     * @return 记录列表
     */
    @Transactional(readOnly = true)
    public List<T> selectAll() {
        RowBounds rowBounds = new RowBounds(1, 10000);
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        return this.baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }


    /**
     * 根据条件查询一条数据
     * 查询结果有多条,将抛异常
     *
     * @param record 记录
     * @return 记录
     */
    @Transactional(readOnly = true)
    public T selectOne(T record) {
        return this.baseMapper.selectOne(record);
    }


    /**
     * 根据条件查询数据
     *
     * @param record 记录
     * @return 记录列表
     */
    @Transactional(readOnly = true)
    public List<T> selectListByWhere(T record) {
        return this.baseMapper.select(record);
    }


    /**
     * 新增数据
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    public Integer insert(T record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return this.baseMapper.insert(record);
    }


    /**
     * 选择不为null的属性作为插入数据的字段，新增数据
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    public Integer insertSelective(T record) {
        Date date = new Date();
        record.setCreateTime(date);
        record.setUpdateTime(date);
        return this.baseMapper.insertSelective(record);
    }

    /**
     * 选择不为null的属性作为插入数据的字段，新增数据,同时不变化时间
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    public Integer insertSelectiveWithOutTimeUpdate(T record) {
        return this.baseMapper.insertSelective(record);
    }


    /**
     * 更新数据
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    @Deprecated
    public Integer update(T record) {
        record.setUpdateTime(new Date());
        return this.baseMapper.updateByPrimaryKey(record);
    }


    /**
     * 选择不为null的属性作为更新数据的字段
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    @Deprecated
    public Integer updateSelective(T record) {
        record.setUpdateTime(new Date());
        return this.baseMapper.updateByPrimaryKeySelective(record);
    }


    /**
     * 根据id删除数据
     *
     * @param id 主键
     * @return 受影响的记录行数
     */
    @Deprecated
    public Integer deleteByPrimaryKey(Serializable id) {
        return this.baseMapper.deleteByPrimaryKey(id);
    }


    /**
     * 根据条件删除数据
     *
     * @param record 记录
     * @return 受影响的记录行数
     */
    public Integer deleteByWhere(T record) {
        return this.baseMapper.delete(record);
    }


    /**
     * 通过条件查询数据列表
     *
     * @param example 条件
     * @return 记录列表
     */
    @Transactional(readOnly = true)
    public List<T> selectByExample(Object example) {
        RowBounds rowBounds = new RowBounds(1, 10000);
        return this.baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }


    /**
     * 通过条件统计数据条数
     *
     * @param example 条件
     * @return 受影响的记录行数
     */
    @Transactional(readOnly = true)
    public Integer selectCountByExample(Object example) {
        return this.baseMapper.selectCountByExample(example);
    }


    /**
     * 通过条件更新数据
     *
     * @param example 条件
     * @param record  记录
     * @return 受影响的记录行数
     */
    public Integer updateByExample(T record, Object example) {
        record.setUpdateTime(new Date());
        return this.baseMapper.updateByExample(record, example);
    }


    /**
     * 选择不为null的属性,通过条件更新数据
     *
     * @param example 条件
     * @param record  记录
     * @return 受影响的记录行数
     */
    public Integer updateByExampleSelective(T record, Object example) {
        record.setUpdateTime(new Date());
        return this.baseMapper.updateByExampleSelective(record, example);
    }

    /**
     * 选择不为null的属性,通过条件更新数据
     *
     * @param example 条件
     * @param record  记录
     * @return 受影响的记录行数
     */
    public Integer updateByExampleSelectiveWithOutTimeUpdate(T record, Object example) {
        return this.baseMapper.updateByExampleSelective(record, example);
    }


    /**
     * 通过条件删除数据
     *
     * @param example 条件
     * @return 受影响的记录行数
     */
    public Integer deleteByExample(Object example) {
        return this.baseMapper.deleteByExample(example);
    }


    /**
     * 分页查询数据
     *
     * @param record    记录
     * @param rowBounds 每页记录数
     * @return 记录列表
     */
    @Transactional(readOnly = true)
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return this.baseMapper.selectByRowBounds(record, rowBounds);
    }


    /**
     * 根据条件分页查询数据
     *
     * @param example   条件
     * @param rowBounds 每页记录数
     * @return 记录列表
     */
    @Transactional(readOnly = true)
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return this.baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }


    /**
     * 批量插入数据
     *
     * @param recordList 记录列表
     * @return 受影响的记录行数
     */
//    @Transactional(propagation = Propagation.REQUIRED)
//    public Integer insertList(List<T> recordList) {
//        for (T record : recordList) {
//            Date date = new Date();
//            record.setCreateTime(date);
//            record.setUpdateTime(date);
//        }
//        return this.baseMapper.insertList(recordList);
//    }

    /**
     * 根据条件查询一条记录
     *
     * @param example 查询条件
     * @return 查询出的结果
     */
    @Transactional(readOnly = true)
    public T selectOneByExample(Object example) {
        RowBounds rowBounds = new RowBounds(1, 1);
        List<T> tList = selectByExampleAndRowBounds(example, rowBounds);
        if (tList.size() > 0) {
            return tList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据条件如果存在则不插入，不存在就插入
     *
     * @param example 查询条件
     * @param record  插入数据
     * @return 1：插入成功，0：插入失败
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertIfNotExistByExample(T record, Object example) {
        if (selectOneByExample(example) != null) {
            return 0;
        } else {
            return insertSelective(record);
        }
    }

    /**
     * 根据条件如果存在则修改，不存在就插入
     *
     * @param record  查询条件
     * @param example 插入数据
     * @return 1：操作成功，0：操作失败
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertIfNotExistByExampleElseUpdate(T record, Object example) {
        if (selectOneByExample(example) != null) {
            return updateByExampleSelective(record, example);
        } else {
            return insertSelective(record);
        }
    }

    /**
     * 根据条件如果存在则修改，不存在就插入,不修改时间
     *
     * @param record  查询条件
     * @param example 插入数据
     * @return 1：操作成功，0：操作失败
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertIfNotExistByExampleElseUpdateWithOutTimeUpdate(T record, Object example) {
        if (selectOneByExample(example) != null) {
            return updateByExampleSelectiveWithOutTimeUpdate(record, example);
        } else {
            return insertSelectiveWithOutTimeUpdate(record);
        }
    }

    /**
     * 批量更新，第一个实体必须带分表主键
     * @param list
     * @return
     */
    /*@Transactional(propagation = Propagation.REQUIRED)
    public Integer batchUpdate(List<T> list) {
        return baseMapper.batchUpdate(list);
    }*/

    /**
     * 根据pid和id查询数据
     *
     * @param pid pid
     * @param id id
     * @return 记录
     */
    @Transactional(readOnly = true)
    public T selectByPidAndId(Long pid, Long id) {
        NullUtil.checkNotNull(pid);
        NullUtil.checkNotNull(id);
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        example.createCriteria().andEqualTo("pid", pid).andEqualTo("id", id);
        return this.baseMapper.selectOneByExample(example);
    }

    /**
     * 通过pid和id更新数据
     *
     * @param pid pid
     * @param id id
     * @param record  记录
     * @return 受影响的记录行数
     */
    public Integer updateByPidAndId(T record, Long pid, Long id) {
        NullUtil.checkNotNull(pid);
        NullUtil.checkNotNull(id);
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        example.createCriteria().andEqualTo("pid", pid).andEqualTo("id", id);

        record.setUpdateTime(new Date());
        return this.baseMapper.updateByExample(record, example);
    }


    /**
     * 选择不为null的属性,通过pid和id更新数据
     *
     * @param pid pid
     * @param id id
     * @param record  记录
     * @return 受影响的记录行数
     */
    public Integer updateByPidAndIdSelective(T record, Long pid, Long id) {
        NullUtil.checkNotNull(pid);
        NullUtil.checkNotNull(id);
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        example.createCriteria().andEqualTo("pid", pid).andEqualTo("id", id);

        record.setUpdateTime(new Date());
        return this.baseMapper.updateByExampleSelective(record, example);
    }

    /**
     * 通过pid和id删除数据
     *
     * @param pid pid
     * @param id id
     * @return 受影响的记录行数
     */
    public Integer deleteByPidAndId(Long pid, Long id) {
        NullUtil.checkNotNull(pid);
        NullUtil.checkNotNull(id);
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        example.createCriteria().andEqualTo("pid", pid).andEqualTo("id", id);

        return this.baseMapper.deleteByExample(example);
    }

    private Example getPidAndIdExample(Long pid, Long id) {
        Class clz = (Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Example example = new Example(clz);
        example.createCriteria().andEqualTo("pid", pid).andEqualTo("id", id);

        return example;
    }


}
