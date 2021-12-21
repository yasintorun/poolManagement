package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.MessageService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.MessageDao;
import com.yasintorun.poolManagement.entities.concretes.Message;

@Service
public class MessageManageer implements MessageService {
	
	private MessageDao messageDao;
	public MessageManageer(MessageDao messageDao) {
		super();
		this.messageDao = messageDao;
	}

	@Override
	public DataResult<List<Message>> getAll() throws Exception {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Message>>(this.messageDao.findAll(),"Mesajlar listlendi");
	}

	@Override
	public DataResult<Message> sendMessage(Message entity) throws Exception {
		Message message=this.messageDao.save(entity);
		return new SuccessDataResult<Message>(message,"Mesaj gönderildi");
	}

}
