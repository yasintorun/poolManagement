package com.yasintorun.poolManagement.business.concretes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasintorun.poolManagement.business.abstracts.AppointmentService;
import com.yasintorun.poolManagement.business.abstracts.UserPackageService;
import com.yasintorun.poolManagement.business.constants.Messages;
import com.yasintorun.poolManagement.core.business.exceptions.EntityNotFound;
import com.yasintorun.poolManagement.core.utilities.results.DataResult;
import com.yasintorun.poolManagement.core.utilities.results.ErrorDataResult;
import com.yasintorun.poolManagement.core.utilities.results.Result;
import com.yasintorun.poolManagement.core.utilities.results.SuccessDataResult;
import com.yasintorun.poolManagement.core.utilities.results.SuccessResult;
import com.yasintorun.poolManagement.dataAccess.abstracts.AppointmentDao;
import com.yasintorun.poolManagement.entities.concretes.Appointment;
import com.yasintorun.poolManagement.entities.concretes.UserPackage;

@Service
public class AppointmentManager implements AppointmentService{
	private AppointmentDao appointmentDao;
	private UserPackageService userPackageService;

	@Autowired
	public AppointmentManager(AppointmentDao appointmentDao, UserPackageService userPackageService) {
		super();
		this.appointmentDao = appointmentDao;
		this.userPackageService = userPackageService;
	}

	@Override
	public DataResult<List<Appointment>> getAll() throws Exception {
		return new SuccessDataResult<List<Appointment>>(this.appointmentDao.findAll(), Messages.appointmentListed);
	}

	//es -> 15:30
	//as -> 15:00
	@Override
	public DataResult<Appointment> add(Appointment entity) throws Exception {
		UserPackage up = this.userPackageService.getByUserId(entity.getUser().getUserId()).getData();
		if(up == null || !up.isStatus()) {
			return new ErrorDataResult<Appointment>("Aktif Havuz Paketi Bulunmamaktadır. Randevu Oluşturulamadı");
		}
		
		List<Appointment> getAppByDate = this.appointmentDao.getByDate(entity.getDate());
		if(getAppByDate != null) {
			LocalTime eSTime = LocalTime.parse(entity.getStartTime()+":00");
			LocalTime eETime = LocalTime.parse(entity.getEndTime()+":00");
			boolean isExist = false;
			for(Appointment ap : getAppByDate) {
				LocalTime apSTime = LocalTime.parse(ap.getStartTime()+":00");
				LocalTime apETime = LocalTime.parse(ap.getEndTime()+":00");
				
				int sDif = apSTime.compareTo(eSTime);
				int eDif = apETime.compareTo(eETime);
				
				
				//Eğer mevcut randevularda başlama saati entity nin başlama ve bitiş saati aralığındaysa randevu oluşturulamaz.
				//Aynı şekilde eğer mevcut randevularda bitiş saati entity nin başlama ve bitiş saati aralığındaysa randevu oluşturulamaz.
				if((sDif > 0 && apSTime.compareTo(eETime)<0) || (eDif < 0 && apETime.compareTo(eSTime) > 0)) {
					return new ErrorDataResult<Appointment>("Havuz şeriti o saatler içerisinde dolu.");
				}	
			}
		}
		
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

	@Override
	public DataResult<List<Appointment>> getAllByUserId(int userId) throws Exception {
		return new SuccessDataResult<List<Appointment>>(this.appointmentDao.getByUser_userId(userId), "Randevularınız listelendi");
	}

	@Override
	public int appointmentCount() throws Exception {
		return this.appointmentDao.findAll().size();
	}

	@Override
	public int appointmentTodayCount() throws Exception {
		return this.appointmentDao.getByDate(LocalDate.now().toString()).size();
	}
	
	
}
