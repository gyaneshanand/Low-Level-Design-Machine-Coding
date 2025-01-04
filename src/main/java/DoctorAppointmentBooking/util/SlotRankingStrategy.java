package DoctorAppointmentBooking.util;

import DoctorAppointmentBooking.model.Slot;

import java.util.List;

public interface SlotRankingStrategy {

    public List<Slot> rankSlots(List<Slot> slots);
}
