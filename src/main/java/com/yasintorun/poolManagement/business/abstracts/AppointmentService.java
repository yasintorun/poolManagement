package com.yasintorun.poolManagement.business.abstracts;

import java.util.List;

import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.entities.concretes.Appointment;

public interface AppointmentService extends CrudService<Appointment>{

	DataResult<List<Appointment>> getAllByUserId(int userId) throws Exception;
	int appointmentCount() throws Exception;
	int appointmentTodayCount() throws Exception;
}
