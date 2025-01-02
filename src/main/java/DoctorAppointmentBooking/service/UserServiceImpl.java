package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Patient;
import DoctorAppointmentBooking.model.User;
import DoctorAppointmentBooking.repository.UserRepository;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = UserRepository.getUserRepository();
    }

    @Override
    public Doctor registerDoc(String name, String speciality) {
        Doctor doctor = new Doctor(name, DoctorSpeciality.valueOf(speciality)); // Builder pattern can be used here
        System.out.println("Welcome Dr. " + doctor.getName());
        return (Doctor) userRepository.addUser(doctor);
    }

    @Override
    public Patient registerPatient(String name) {
        Patient p = new Patient(name);
        System.out.println(p.getName() + " registered successfully.");
        return (Patient) userRepository.addUser(p);
    }

    public User getUserById(Integer id){
        return userRepository.getUserById(id);
    }

    public User getUserByName(String name){
        return userRepository.getUserByName(name);
    }

}
