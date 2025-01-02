package DoctorAppointmentBooking.model;

import DoctorAppointmentBooking.constant.DoctorSpeciality;
import DoctorAppointmentBooking.constant.SlotOccupancyStatus;

import java.time.LocalTime;

public class Slot {

    private LocalTime startTime;
    private LocalTime endTime;
    private SlotOccupancyStatus slotOccupancyStatus;
    private Doctor doctor;
    private Appointment appointment;

    public Slot(LocalTime startTime, LocalTime endTime, Doctor doctor) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
        this.slotOccupancyStatus = SlotOccupancyStatus.VACANT;
        this.appointment = null;
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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public DoctorSpeciality getDocSpecialtiy(){
        return this.doctor.getDoctorSpeciality();
    }
}
