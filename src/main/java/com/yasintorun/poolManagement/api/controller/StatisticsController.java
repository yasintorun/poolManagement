package com.yasintorun.poolManagement.api.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yasintorun.poolManagement.business.abstracts.AppointmentService;
import com.yasintorun.poolManagement.business.abstracts.PoolLaneService;
import com.yasintorun.poolManagement.business.abstracts.PoolPackageService;
import com.yasintorun.poolManagement.business.abstracts.PoolService;
import com.yasintorun.poolManagement.business.abstracts.UserPackageService;
import com.yasintorun.poolManagement.business.abstracts.UserService;
import com.yasintorun.poolManagement.entities.concretes.PoolPackage;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;
import com.yasintorun.poolManagement.entities.dtos.AdminStatisticDto;
import com.yasintorun.poolManagement.entities.dtos.ClientStatisticDto;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController extends BaseController{
	private PoolService poolService;
	private AppointmentService appointmentService;
	private UserService userService;
	private PoolPackageService poolPackageService;
	private PoolLaneService poolLaneService;
	private UserPackageService userPackageService;
	@Autowired
	public StatisticsController(PoolService poolService, AppointmentService appointmentService, UserService userService,
			PoolPackageService poolPackageService, PoolLaneService poolLaneService, UserPackageService userPackageService) {
		super();
		this.poolService = poolService;
		this.appointmentService = appointmentService;
		this.userService = userService;
		this.poolPackageService = poolPackageService;
		this.poolLaneService = poolLaneService;
		this.userPackageService = userPackageService;
	}
	
	@GetMapping("/adminstatistics")
	public ResponseEntity<?> getAdminStatistics() {
		AdminStatisticDto asDto = new AdminStatisticDto();
		try {
			asDto.setPoolCount(poolService.getPoolCount());
			asDto.setAppointmentCount(appointmentService.appointmentCount());
			asDto.setAppointmentTodayCount(appointmentService.appointmentTodayCount());
			asDto.setTotalEarning(150);
			asDto.setTotalLaneCount(poolLaneService.laneCount());
			asDto.setTotalPoolPackageCount(poolPackageService.poolPackageCount());
			asDto.setTotalClientCount(userService.totalUserCount());
			asDto.setTotalActivePackageCount(userPackageService.totalActivePackage());
			return ResponseEntity.ok(asDto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("İstatistikler getirilemiyor...");
		}
	}
	
	@GetMapping("/clientstatistics")
	public ResponseEntity<?> getClientStatistics(int userId) {
		ClientStatisticDto csDto = new ClientStatisticDto();
		try {
			csDto.setTotalAppointmentCount(appointmentService.getAllByUserId(userId).getData().size());
			csDto.setTotalReamingCount(userPackageService.totalReamingCountByUserId(userId));
			csDto.setUserId(userId);
			return ResponseEntity.ok(csDto);
		} catch(Exception e) {
			return ResponseEntity.badRequest().body("İstatistikler getirilemiyor");
		}
	}
	
}
