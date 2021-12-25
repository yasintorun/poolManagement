package com.yasintorun.poolManagement.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminStatisticDto {
	private int poolCount;
	private int appointmentCount;
	private int appointmentTodayCount;
	private int totalEarning;
	private int totalClientCount;
	private int totalPoolPackageCount;
	private int totalLaneCount;
	private int totalActivePackageCount;
}
