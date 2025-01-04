package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;

import java.time.LocalTime;
import java.util.List;

public interface SlotService {

    public String createSlot(String startTime, String endTime, Doctor doctor);
    public List<Slot> getAllSlots();
    public String markDocAvailability(String docName, String slotTimeList);
    public Slot getSlotByDoctorAndStartTime(Integer doctorId, LocalTime startTime);

    public void showAvailByspeciality(String speciality);

}
