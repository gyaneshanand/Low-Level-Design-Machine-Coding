package DoctorAppointmentBooking;

import DoctorAppointmentBooking.model.Appointment;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;
import DoctorAppointmentBooking.service.*;
import DoctorAppointmentBooking.util.SlotRankingStrategy;
import DoctorAppointmentBooking.util.StartTimeBasedRankingStrategy;

public class AppointmentBookingSystem {

    public static void main(String[] args) {

        SlotRankingStrategy slotRankingStrategy = new StartTimeBasedRankingStrategy();
        UserService userService = new UserServiceImpl();
        SlotService slotService = new SlotServiceImpl(slotRankingStrategy);
        AppointmentService appointmentService = new AppointmentServiceImpl();

        Doctor d1 = userService.registerDoc("Curious", "Cardiologist");
        Doctor d2 = userService.registerDoc("Anna", "Cardiologist");
        userService.registerPatient("PatientA");
        userService.registerPatient("PatientB");

        System.out.println(slotService.markDocAvailability("Curious", "09:30-10:00, 12:30-13:00, 16:00-16:30"));
        System.out.println(slotService.markDocAvailability("Anna", "09:30-10:00,"));
        System.out.println(slotService.markDocAvailability("Curious", "09:30-10:00,"));
        slotService.showAvailByspeciality("Cardiologist");

        Appointment a1 = appointmentService.bookAppointment("PatientA", "Curious", "09:30");
        Appointment a2 = appointmentService.bookAppointment("PatientB", "Curious", "09:30");

        appointmentService.cancelAppointment(a1.getId());
    }
}
