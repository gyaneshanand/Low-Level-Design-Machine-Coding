package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;
import DoctorAppointmentBooking.repository.InMemorySlotRepository;
import DoctorAppointmentBooking.repository.SlotRepository;
import DoctorAppointmentBooking.util.Validator;

import java.time.LocalTime;
import java.util.List;

public class SlotServiceImpl implements SlotService{

    SlotRepository slotRepository;
    UserService userService;

    public SlotServiceImpl(SlotRepository slotRepository) {
        this.slotRepository = InMemorySlotRepository.getInstance();
        this.userService = new UserServiceImpl();
    }

    @Override
    public String createSlot(String startTime, String endTime, Doctor doctor) {
        // Convert the Time into LocalTime using time util :- format - "HH:mm" or "H:mm"
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);

        // Validate if the doctor does not have the slot at the given startTime
        Slot slot = slotRepository.getSlotByDoctorAndStartTime(doctor.getId(), start);
        if(slot != null){
            return "Slot already exists for the doctor at the given timeslot" + start + " - " + end;
        }

        // Run Other Validations eg - Slot should not be more than 30 mins
        Validator.validateSlot(start, end);

        // Create the slot
        return null;
    }

    @Override
    public List<Slot> getAllSlots() {
        return null;
    }

    public String markDocAvailability(String docName, String slotTimeList){
        // Get the doctor by name
        Doctor doctor = (Doctor) userService.getUserByName(docName);
        if(doctor==null){
            return "Invalid Doctor name. This doctor does not exist.";
        }

        // Get the list of slots from the string 9:30-10:00, 12:30-13:00, 16:00-16:30
        String[] slotTimes = slotTimeList.split(",");
        for(String slotTime: slotTimes){
            String[] times = slotTime.split("-");
            String startTime = times[0];
            String endTime = times[1];
            createSlot(startTime, endTime, doctor);
        }

        return "Done Doc!";
    }

    // Get All the slots for a doctor
    private List<Slot> getAllSlotsForDoctor(Doctor doctor){
        return null;
    }
}
