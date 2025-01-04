package DoctorAppointmentBooking.model;

public class Patient extends User{

    public Patient(String name) {
        super((int) (Math.random() * 1000), name);
    }
}
