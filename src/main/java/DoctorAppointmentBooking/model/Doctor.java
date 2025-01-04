package DoctorAppointmentBooking.model;

import DoctorAppointmentBooking.constant.DoctorSpeciality;

public class Doctor extends User {

    private DoctorSpeciality doctorSpeciality;

    public Doctor(String name, DoctorSpeciality doctorSpeciality) {
        super((int) (Math.random() * 1000), name);
        this.doctorSpeciality = doctorSpeciality;
    }

    public DoctorSpeciality getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public void setDoctorSpeciality(DoctorSpeciality doctorSpeciality) {
        this.doctorSpeciality = doctorSpeciality;
    }
}
