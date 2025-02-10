import java.time.LocalDateTime;
import java.time.Duration;


public class AttendanceRecord{
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    //Constructor
    public AttendanceRecord(LocalDateTime checkIn, LocalDateTime checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    //get checkIn
    public LocalDateTime getcheckIn(){
        return checkIn;

    }
    //get checkOut
    public LocalDateTime getCheckOut(){
        return checkOut;
    }

    //to calculate number of hours worked
    public Duration getHoursWorked(){
        return Duration.between(checkIn, checkOut);
    }

    @Override
    public String toString(){
        return "Check-In: " +checkIn + ", Check-Out: " +checkOut;
    }
}