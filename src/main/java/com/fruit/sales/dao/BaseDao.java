package com.fruit.sales.dao;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> extends Serializable{
	/**
     * 插入指定的持久化对象
     * @param obj
     * @return
     */
    void save(T obj);
    /**
     * 修改指定的持久化对象
     * @param obj
     */
    void update(T obj);
    /**
     * 删除指定的持久化对象
     * @param id
     */
    void delete(T obj);
    /**
     * 删除指定id的持久化对象
     * @param id
     */
	void delete(Serializable id);
    /**
     * 全部删除持久化对象
     */
	void deleteAll();
    /**
     * 根据ID检索持久化对象
     */
	T findById(Serializable id);
    /**
     * 检索所有持久化对象
     */
	List<T> findAll();
    /**
     * 检索指定页和指定条数的持久化对象
     * @param pageNo
     * @param pageSize
     */
	QueryResult<T> findByPageList(int pageNo, int pageSize);
    /**
     * 根据条件检索指定页和指定条数的持久化对象
     * @param pageNo
     * @param pageSize
     */
	QueryResult<T> findByPageList(int pageNo, int pageSize, Map<String, String> where);
    /**
     * 根据排序检索指定页和指定条数的持久化对象
     * @param pageNo
     * @param pageSize
     */
	QueryResult<T> findByPageList(int pageNo, int pageSize, LinkedHashMap<String, String> orderby);
    /**
     * 根据条件和排序检索指定页和指定条数的持久化对象
     * @param pageNo
     * @param pageSize
     */
	QueryResult<T> findByPageList(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby);
}
