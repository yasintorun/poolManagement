package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.entities.concretes.Message;

public interface MessageService {
	DataResult<List<Message>> getAll() throws Exception;
	DataResult<Message> sendMessage(Message entity) throws Exception;
}
