package com.yasintorun.poolManagement.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer>{
	boolean existsByAppointmentId(int appointmentId);
	List<Appointment> getByUser_userId(int userId);
	List<Appointment> getByDate(String date);
}
