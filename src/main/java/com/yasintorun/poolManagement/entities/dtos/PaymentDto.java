package com.yasintorun.poolManagement.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
	private int userId;
	private int amount;
	private int packageId;
	private String paymentDate;
	private CreditCard creditCard;
}
