package DoctorAppointmentBooking.util;

import java.time.LocalTime;

public class Validator {

    public static boolean validateSlot(LocalTime startTime, LocalTime endTime){
        // Validate if the slot is not more than 30 mins
        if(!startTime.plusMinutes(30).isAfter(endTime)){
            return false;
        }
        return true;
    }
}
