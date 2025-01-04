package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.model.Appointment;

public interface AppointmentService {

    public Appointment bookAppointment(String patientName, String doctorName, String slotStartTime);
    public Appointment cancelAppointment(Integer appointmentId);
}
