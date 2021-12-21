package com.yasintorun.poolManagement.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.MessageService;
import com.yasintorun.poolManagement.entities.concretes.Message;

@RestController
@RequestMapping("/api/messages")
public class MessageController extends BaseController {
	
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return Ok(()->this.messageService.getAll());
	}
	
	@PostMapping("/sendmessage")
	public ResponseEntity<?> sendMessage(@RequestBody Message message){
		return Ok(()->this.messageService.sendMessage(message));
	}
}
