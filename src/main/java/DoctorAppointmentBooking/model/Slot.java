package DoctorAppointmentBooking.model;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.constant.SlotOccupancyStatus;

import java.time.LocalTime;

public class Slot {

    private LocalTime startTime;
    private LocalTime endTime;
    private SlotOccupancyStatus slotOccupancyStatus;
    private Doctor doctor;

    public Slot(LocalTime startTime, LocalTime endTime, Doctor doctor) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
        this.slotOccupancyStatus = SlotOccupancyStatus.VACANT;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public SlotOccupancyStatus getSlotOccupancyStatus() {
        return slotOccupancyStatus;
    }

    public void setSlotOccupancyStatus(SlotOccupancyStatus slotOccupancyStatus) {
        this.slotOccupancyStatus = slotOccupancyStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public DoctorSpeciality getDocSpecialtiy(){
        return this.doctor.getDoctorSpeciality();
    }
}
