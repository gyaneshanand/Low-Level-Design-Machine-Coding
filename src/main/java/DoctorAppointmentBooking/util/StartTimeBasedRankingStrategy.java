package DoctorAppointmentBooking.util;

import DoctorAppointmentBooking.model.Slot;

import java.util.List;

public class StartTimeBasedRankingStrategy implements SlotRankingStrategy {

    @Override
    public List<Slot> rankSlots(List<Slot> slots) {
        // Order the Slots based on the start time
        slots.sort((s1, s2) -> s1.getStartTime().compareTo(s2.getStartTime()));
        return slots;
    }
}
