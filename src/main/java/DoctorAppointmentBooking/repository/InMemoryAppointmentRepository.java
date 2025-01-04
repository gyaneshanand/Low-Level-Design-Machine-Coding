package DoctorAppointmentBooking.repository;

import DoctorAppointmentBooking.model.Appointment;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAppointmentRepository {

    Map<Integer, Appointment> appointments;
    private static InMemoryAppointmentRepository appointmentRepository;

    private InMemoryAppointmentRepository(){
        appointments = new HashMap<>();
    }

    public static InMemoryAppointmentRepository getAppointmentRepository(){
        if(appointmentRepository == null){
            appointmentRepository = new InMemoryAppointmentRepository();
        }
        return appointmentRepository;
    }

    // create a new appointment
    public Appointment addAppointment(Appointment appointment){
        appointments.put(appointment.getId(), appointment);
        return appointment;
    }

    // get appointment by id
    public Appointment getAppointmentById(Integer id){
        return appointments.get(id);
    }

    // Remove appointment by id
    public void removeAppointmentById(Integer id){
        appointments.remove(id);
    }

    // Get all appointments
    public Map<Integer, Appointment> getAllAppointments(){
        return appointments;
    }

    // Get Appointment booked by a patient at given start time
    public Appointment getAppointmentByPatientAndStartTime(Integer patientId, LocalTime startTime){
        Appointment appointment = appointments.values().stream()
                .filter(a -> a.getPatient().getId() == patientId && a.getSlot().getStartTime().compareTo(startTime)==0)
                .findFirst()
                .orElse(null);
        return appointment;
    }

    // Get Appointment booked for a doctor at given start time
    public Appointment getAppointmentByDoctorAndStartTime(Integer doctorId, LocalTime startTime){
        Appointment appointment = appointments.values().stream()
                .filter(a -> a.getSlot().getDoctor().getId() == doctorId && a.getSlot().getStartTime().compareTo(startTime)==0)
                .findFirst()
                .orElse(null);
        return appointment;
    }

    // Get Appointment booked for a doctor at given start time which is waitlisted
    public Appointment getWaitListedAppointmentByDoctorAndStartTime(Integer doctorId, LocalTime startTime){
        Appointment appointment = appointments.values().stream()
                .filter(a -> a.getSlot().getDoctor().getId() == doctorId && a.getSlot().getStartTime().compareTo(startTime)==0 && a.getWaitList())
                .findFirst()
                .orElse(null);
        return appointment;
    }

}
