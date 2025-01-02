package DoctorAppointmentBooking;

import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.service.UserService;
import DoctorAppointmentBooking.service.UserServiceImpl;

public class AppointmentBookingSystem {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        Doctor d1 = userService.registerDoc("Curious", "Cardiologist");
        userService.registerPatient("PatientA");


    }
}
