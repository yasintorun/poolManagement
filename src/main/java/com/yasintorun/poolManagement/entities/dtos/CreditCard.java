package com.yasintorun.poolManagement.entities.dtos;

import lombok.Data;

@Data
public class CreditCard {
	private String cardNumber;
	private String cardName;
	private String cvv;
	private String expirationDate;
}
