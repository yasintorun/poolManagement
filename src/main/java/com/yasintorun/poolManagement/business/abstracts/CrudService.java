package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;

public interface CrudService<T> {
	DataResult<List<T>> getAll() throws Exception;
	DataResult<T> add(T entity) throws Exception;
	DataResult<T> update(T entity) throws Exception;
	Result delete(T entity) throws Exception;
}
