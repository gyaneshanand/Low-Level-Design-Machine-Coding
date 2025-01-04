package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.constant.SlotOccupancyStatus;
import DoctorAppointmentBooking.model.Appointment;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Patient;
import DoctorAppointmentBooking.model.Slot;
import DoctorAppointmentBooking.repository.InMemoryAppointmentRepository;

import java.time.LocalTime;

public class AppointmentServiceImpl implements AppointmentService{

    UserService userService;
    SlotService slotService;
    InMemoryAppointmentRepository appointmentRepository;

    public AppointmentServiceImpl() {
        this.userService = new UserServiceImpl();
        this.slotService = new SlotServiceImpl();
        this.appointmentRepository = InMemoryAppointmentRepository.getAppointmentRepository();
    }


    @Override
    public Appointment bookAppointment(String patientName, String doctorName, String slotStartTime) {
        // Get the patient and doctor objects
        Patient patient = (Patient) userService.getUserByName(patientName);
        Doctor doctor = (Doctor) userService.getUserByName(doctorName);

        // Get the slot object for the given start time and doctor
        LocalTime startTime = LocalTime.parse(slotStartTime);
        Slot slot = slotService.getSlotByDoctorAndStartTime(doctor.getId(), startTime);
        if(slot == null){
            System.out.println("Slot not available for the doctor at the given time");
            return null;
        }

        // Validate No other slot has been booked by the patient at the same time
        Appointment existingAppointment = appointmentRepository.getAppointmentByPatientAndStartTime(patient.getId(), startTime);
        if (existingAppointment != null) {
            System.out.println("Appointment already exists for the patient at the given time");
            return null;
        }

        // Create a new appointment
        // Get Random Appointment Id
        Integer appointmentId = (int) (Math.random() * 1000);
        Appointment appointment = new Appointment(appointmentId, slot, patient);
        // If the slot is already booked, add the patient to the waitlist
        if(slot.getSlotOccupancyStatus().equals(SlotOccupancyStatus.BOOKED)){
            appointment.setWaitList(true);
        }
        slot.setSlotOccupancyStatus(SlotOccupancyStatus.BOOKED);
        appointmentRepository.addAppointment(appointment);
        if(appointment.getWaitList()){
            System.out.println("Added to the waitlist. Booking id: " + appointmentId);
        }
        else {
            System.out.println("Booked. Booking id: " + appointmentId);
        }


        // List All appointments
        System.out.println("** All Appointments List **");
        appointmentRepository.getAllAppointments().forEach((k,v) -> System.out.println("Appointment Id: " + k + " | Patient: " + v.getPatient().getName() + " | Doctor: " + v.getSlot().getDoctor().getName() + " | Time: " + v.getSlot().getStartTime() + "-" + v.getSlot().getEndTime() + " | Waitlist: " + v.getWaitList()));
        System.out.println();

        return appointment;
    }

    @Override
    public Appointment cancelAppointment(Integer appointmentId) {
        // Get the appointment object to be cancelled
        Appointment appointmentToCancel = appointmentRepository.getAppointmentById(appointmentId);

        // Check if there is any appointment for the doctor at the same time which is waitlisted
        Appointment waitListedAppointment = appointmentRepository.getWaitListedAppointmentByDoctorAndStartTime(appointmentToCancel.getSlot().getDoctor().getId(), appointmentToCancel.getSlot().getStartTime());

        // Remove the appointment to be cancelled
        appointmentRepository.removeAppointmentById(appointmentId);
        System.out.println("Booking Cancelled");

        // If there is any waitlisted appointment, book it
        if(waitListedAppointment != null){
            waitListedAppointment.setWaitList(false);
            waitListedAppointment.getSlot().setSlotOccupancyStatus(SlotOccupancyStatus.BOOKED);
            System.out.println("Booking confirmed for Booking id: " + waitListedAppointment.getId());
        }
        return null;
    }


}
