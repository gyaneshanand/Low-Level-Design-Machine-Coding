package DoctorAppointmentBooking.model;

public class Appointment {
    private Integer id;
    private Slot slot;
    private Patient patient;
    private Boolean isWaitList;

    public Appointment(Integer id, Slot slot, Patient patient) {
        this.id = id;
        this.slot = slot;
        this.patient = patient;
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

    public Boolean getWaitList() {
        return isWaitList;
    }

    public void setWaitList(Boolean waitList) {
        isWaitList = waitList;
    }
}
