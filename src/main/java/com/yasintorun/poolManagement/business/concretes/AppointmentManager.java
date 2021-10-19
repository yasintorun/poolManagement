package com.yasintorun.poolManagement.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AppointmentService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.AppointmentDao;
import com.yasintorun.poolManagement.entities.concretes.Appointment;

@Service
public class AppointmentManager implements AppointmentService{
	private AppointmentDao appointmentDao;

	@Autowired
	public AppointmentManager(AppointmentDao appointmentDao) {
		super();
		this.appointmentDao = appointmentDao;
	}

	@Override
	public DataResult<List<Appointment>> getAll() throws Exception {
		return new SuccessDataResult<List<Appointment>>(this.appointmentDao.findAll(), Messages.appointmentListed);
	}

	@Override
	public DataResult<Appointment> add(Appointment entity) throws Exception {
		Appointment addedAppointment = this.appointmentDao.save(entity);
		return new SuccessDataResult<Appointment>(addedAppointment, Messages.appointmentAdded);
	}

	@Override
	public DataResult<Appointment> update(Appointment entity) throws Exception {
		if(this.appointmentDao.existsByAppointmentId(entity.getAppointmentId())) {
			throw new EntityNotFound("appointment");
		}
		Appointment updatedAppointment = this.appointmentDao.save(entity);
		return new SuccessDataResult<Appointment>(updatedAppointment, Messages.appointmentUpdated);
	}

	@Override
	public Result delete(Appointment entity) throws Exception {
		if(this.appointmentDao.existsByAppointmentId(entity.getAppointmentId())) {
			throw new EntityNotFound("appointment");
		}
		
		this.appointmentDao.delete(entity);
		return new SuccessResult(Messages.appointmentDeleted);
	}
	
	
}
