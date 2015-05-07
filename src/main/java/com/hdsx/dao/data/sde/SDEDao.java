package com.hdsx.dao.data.sde;

import java.util.List;

import com.hdsx.dao.data.Feature;
import com.hdsx.dao.parameter.Parameters;

public interface SDEDao {
	/**
	 * 单条查询.
	 *
	 * @param QueryParameters parameters
	 * @return the t
	 */
	List<Feature> query(Parameters parameters);
	/**
	 * 插入.
	 *
	 * @param ModifyParameter parameters
	 * @return the int
	 */
	int insert(Parameters parameters);
	
	/**
	 * 修改.
	 *
	 * @param ModifyParameter parameters
	 * @return the int
	 */
	int update(Parameters parameters);
	
	/**
	 * 删除.
	 *
	 * @param ModifyParameter parameters
	 * @return the int
	 */
	int delete(Parameters parameters);
	/**
	 * 计量.
	 *
	 * @param ModifyParameter parameters
	 * @return the int
	 */
	int count(Parameters parameters);
	
}
