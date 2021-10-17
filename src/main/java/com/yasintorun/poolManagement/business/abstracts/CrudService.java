package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;

public interface CrudService<T> {
	DataResult<List<T>> getAll();
	DataResult<T> add(T entity);
	DataResult<T> update(T entity);
	Result delete(T entity);
}
