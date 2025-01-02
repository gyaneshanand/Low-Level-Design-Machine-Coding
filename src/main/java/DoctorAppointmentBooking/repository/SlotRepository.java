package DoctorAppointmentBooking.repository;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;

import java.time.LocalTime;
import java.util.List;

public interface SlotRepository {

    public void addSlot(Slot slot);
    public List<Slot> getAllSlots();
    public List<Slot> getSlotsByDoctor(Integer doctorId);
    public Slot getSlotByDoctorAndStartTime(Integer doctorId, LocalTime startTime);
    public List<Slot> getSlotsByDoctorSpeciality(DoctorSpeciality doctorSpeciality);

}
