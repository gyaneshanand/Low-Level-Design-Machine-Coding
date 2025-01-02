package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;

import java.time.LocalTime;
import java.util.List;

public interface SlotService {

    public String createSlot(String startTime, String endTime, Doctor doctor);
    public List<Slot> getAllSlots();

}
