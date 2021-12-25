package com.yasintorun.poolManagement.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.MessageService;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
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
		Sort sort = Sort.by(Sort.Direction.DESC, "id");
		return new SuccessDataResult<List<Message>>(this.messageDao.findAll(sort),"Mesajlar listlendi");
	}

	@Override
	public DataResult<Message> sendMessage(Message entity) throws Exception {
		entity.setRead(false);
		entity.setCreatedAt(LocalDate.now());	
		Message message=this.messageDao.save(entity);
		return new SuccessDataResult<Message>(message,"Mesaj gönderildi");
	}

	@Override	
	public DataResult<Message> getById(int id) throws Exception {
		Message msg = this.messageDao.findById(id).get();
		if(msg == null) {
			return new ErrorDataResult<Message>("Mesaj bulunamadı");
		}
		msg.setRead(true);
		this.messageDao.save(msg);
		return new SuccessDataResult<Message>(msg, "Mesaj detayı getirildi");
	}

}
