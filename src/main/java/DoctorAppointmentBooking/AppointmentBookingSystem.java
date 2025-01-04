package DoctorAppointmentBooking;

import DoctorAppointmentBooking.model.Appointment;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;
import DoctorAppointmentBooking.service.*;

public class AppointmentBookingSystem {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        SlotService slotService = new SlotServiceImpl();
        AppointmentService appointmentService = new AppointmentServiceImpl();

        Doctor d1 = userService.registerDoc("Curious", "Cardiologist");
        userService.registerPatient("PatientA");

        System.out.println(slotService.markDocAvailability("Curious", "09:30-10:00, 12:30-13:00, 16:00-16:30"));


        System.out.println(slotService.markDocAvailability("Curious", "19:30-22:00,"));
        for(Slot slot : slotService.getAllSlots()){
            System.out.println(slot.getDoctor().getName() + " | " + slot.getStartTime() + " | " + slot.getEndTime());
        }

        appointmentService.bookAppointment("PatientA", "Curious", "09:30");
    }
}
