package com.adeprogramming.universalpetcare.service.appointment;

import com.adeprogramming.universalpetcare.model.Appointment;
import com.adeprogramming.universalpetcare.request.AppointmentRequest;

import java.util.List;

public interface IAppointmentService {
    Appointment createAppointment(Appointment appointment, Long sender, Long recipient);
    List<Appointment>getAllAppointments();
    Appointment updateAppointment(Long id, AppointmentRequest request);
    void deleteAppointment(Long id);
    Appointment getAppointmentByID(Long id);
    Appointment getAppointmentByNo (String appointmentNo);

}
