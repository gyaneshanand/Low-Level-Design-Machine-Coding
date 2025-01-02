package DoctorAppointmentBooking.model;

public class Appointment {
    private Integer id;
    private Slot slot;
    private Patient patient;
    private Doctor doctor;
    private Boolean isWaitList;

    public Appointment(Integer id, Slot slot, Patient patient, Doctor doctor) {
        this.id = id;
        this.slot = slot;
        this.patient = patient;
        this.doctor = doctor;
        this.isWaitList = false;
    }

    public Integer getId() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Boolean getWaitList() {
        return isWaitList;
    }

    public void setWaitList(Boolean waitList) {
        isWaitList = waitList;
    }
}
