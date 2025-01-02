package DoctorAppointmentBooking.repository;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.model.Slot;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemorySlotRepository implements SlotRepository{

    private static InMemorySlotRepository inMemorySlotRepository;
    private List<Slot> slots;

    private InMemorySlotRepository(){
        slots = new ArrayList<>();
    }

    public static InMemorySlotRepository getInstance(){
        if(inMemorySlotRepository == null){
            inMemorySlotRepository = new InMemorySlotRepository();
        }
        return inMemorySlotRepository;
    }

    public void addSlot(Slot slot){
        slots.add(slot);
    }

    public List<Slot> getAllSlots(){
        return slots;
    }

    // Get the slot by the doctor
    public List<Slot> getSlotsByDoctor(Integer doctorId){
        List<Slot> doctorSlots = slots.stream().filter(slot -> slot.getDoctor().getId() == doctorId).collect(Collectors.toList());
        return doctorSlots;
    }

    // Get the slots by doctor speciality
    public List<Slot> getSlotsByDoctorSpeciality(DoctorSpeciality doctorSpeciality){
        List<Slot> doctorSlots = slots.stream().filter(slot -> slot.getDoctor().getDoctorSpeciality().equals(doctorSpeciality) ).collect(Collectors.toList());
        return doctorSlots;
    }

    // Get Doctor Slot by Time
    public Slot getSlotByDoctorAndStartTime(Integer doctorId, LocalTime startTime){
        Slot slot = slots.stream().filter(s -> s.getDoctor().getId() == doctorId && s.getStartTime().compareTo(startTime)==0).findFirst().orElse(null);
        return slot;
    }
}
