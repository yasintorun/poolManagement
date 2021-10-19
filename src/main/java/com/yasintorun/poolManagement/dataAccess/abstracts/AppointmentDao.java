package com.yasintorun.poolManagement.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yasintorun.poolManagement.entities.concretes.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, Integer>{
	boolean existsByAppointmentId(int appointmentId);
}
