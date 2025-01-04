package DoctorAppointmentBooking.service;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.model.Doctor;
import DoctorAppointmentBooking.model.Slot;
import DoctorAppointmentBooking.repository.InMemorySlotRepository;
import DoctorAppointmentBooking.repository.SlotRepository;
import DoctorAppointmentBooking.util.SlotRankingStrategy;
import DoctorAppointmentBooking.util.StartTimeBasedRankingStrategy;
import DoctorAppointmentBooking.util.Validator;

import java.time.LocalTime;
import java.util.List;

public class SlotServiceImpl implements SlotService{

    SlotRepository slotRepository;
    UserService userService;
    SlotRankingStrategy slotRankingStrategy;

    public SlotServiceImpl() {
        this.slotRepository = InMemorySlotRepository.getInstance();
        this.userService = new UserServiceImpl();
        this.slotRankingStrategy = new StartTimeBasedRankingStrategy(); // Default Strategy
    }

    public SlotServiceImpl(SlotRankingStrategy slotRankingStrategy) {
        this.slotRepository = InMemorySlotRepository.getInstance();
        this.userService = new UserServiceImpl();
        this.slotRankingStrategy = slotRankingStrategy;
    }

    @Override
    public String createSlot(String startTime, String endTime, Doctor doctor) {
        // Convert the Time into LocalTime :- format - "HH:mm" or "H:mm"
        LocalTime start = LocalTime.parse(startTime);
        LocalTime end = LocalTime.parse(endTime);

        // Validate if the doctor does not have the slot at the given startTime
        Slot slot = slotRepository.getSlotByDoctorAndStartTime(doctor.getId(), start);
        if(slot != null){
            return "Slot already exists for the doctor at the given timeslot - " + start + " - " + end;
        }

        // Run Other Validations eg - Slot should not be more than 30 mins
        if(!Validator.validateSlot(start, end)){
            return "Invalid Slot for the given timeslot - " + start + " - " + end;
        }

        // Create the slot
        slotRepository.addSlot(new Slot(start, end, doctor));
        return "Slot created successfully for Doctor : " + doctor.getName() + " | Time : "+ start + "-" + end;
    }

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.getAllSlots();
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
            String startTime = times[0].strip();
            String endTime = times[1].strip();
            System.out.println(createSlot(startTime, endTime, doctor));
        }

        return "Done Doc!";
    }

    // Get All the slots for a doctor
    private List<Slot> getAllSlotsForDoctor(Doctor doctor){
        return null;
    }

    // Get Slot for Doctor for given start time and doctor
    public Slot getSlotByDoctorAndStartTime(Integer doctorId, LocalTime startTime){
        return slotRepository.getSlotByDoctorAndStartTime(doctorId, startTime);
    }

    @Override
    public void showAvailByspeciality(String speciality) {
        List<Slot> slots = slotRepository.getSlotsByDoctorSpeciality(DoctorSpeciality.valueOf(speciality));
        slotRankingStrategy.rankSlots(slots);
        slots.forEach(slot -> System.out.println(slot.getDoctor().getName() + " | " + slot.getStartTime() + " | " + slot.getEndTime()));
    }
}
