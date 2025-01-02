package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Patient;
import DoctorAppointmentBooking.model.User;

public interface UserService {

    public Doctor registerDoc(String name, String speciality);
    public Patient registerPatient(String name);
    public User getUserById(Integer id);
    public User getUserByName(String name);

}
