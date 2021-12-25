package com.yasintorun.poolManagement.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientStatisticDto {
	private int userId;
	private int totalAppointmentCount;
	private int totalReamingCount;
}
