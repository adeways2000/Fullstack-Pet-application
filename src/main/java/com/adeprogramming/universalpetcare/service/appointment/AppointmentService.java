package com.adeprogramming.universalpetcare.service.appointment;

import com.adeprogramming.universalpetcare.enums.AppointmentStatus;
import com.adeprogramming.universalpetcare.exception.ResourceNotFoundException;
import com.adeprogramming.universalpetcare.model.Appointment;
import com.adeprogramming.universalpetcare.model.User;
import com.adeprogramming.universalpetcare.repository.AppointmentRepository;
import com.adeprogramming.universalpetcare.repository.UserRepository;
import com.adeprogramming.universalpetcare.request.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService implements  IAppointmentService {
    private  final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;
    @Override
    public Appointment createAppointment(Appointment appointment, Long senderId, Long recipientId) {
        Optional<Object> sender = userRepository.findById(senderId);
        Optional<Object> recipient = userRepository.findById(recipientId);
        if(sender.isPresent() && recipient.isPresent()){
            appointment.setPatient((User) sender.get());
            appointment.setVeterinarian((User) recipient.get());
            appointment.setAppointmentNo();
            appointment.setStatus(AppointmentStatus.WAITING_FOR_APPROVAL);
            return  appointmentRepository.save(appointment);
        }
        throw new ResourceNotFoundException("sender or recipient not found");
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, AppointmentRequest request) {
        return null;
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.findById(id)
                .ifPresent(appointmentRepository::delete);

    }

    @Override
    public Appointment getAppointmentByID(Long id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("appointment not found"));
    }

    @Override
    public Appointment getAppointmentByNo(String appointmentNo) {
        return appointmentRepository.findByAppointmentNo(appointmentNo);
    }
}
