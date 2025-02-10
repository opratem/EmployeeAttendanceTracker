import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class AttendanceTracker {
    private Map<Integer, List<AttendanceRecord>> attendanceRecords;

    //Constructor
    public AttendanceTracker(){
        attendanceRecords = new HashMap<>();
    }

    //to add new attendace record for an employee

    public void addRecord(int employeeId, LocalDateTime checkIn, LocalDateTime checkOut){
        AttendanceRecord record = new AttendanceRecord(checkIn, checkOut);
    

    //to check if the employee doesn't have records yet, create a new list 

    attendanceRecords.putIfAbsent (employeeId, new ArrayList<>());

    //Add the record to the employee's list
    attendanceRecords.get(employeeId).add(record);
    }

    //method to get all attendance records of an employee
    public List<AttendanceRecord> getRecords(int employeeId){
        return attendanceRecords.getOrDefault(employeeId, new ArrayList<>());

    }

    //calculate the numbers of hours worked by an employee
    public Duration getTotalHoursWorked (int employeeId){
        List <AttendanceRecord> records = attendanceRecords.getOrDefault(employeeId, new ArrayList<>());

        //initialize the totalHours variable
        Duration totalHours = Duration.ZERO;

        for (AttendanceRecord record : records){
            totalHours = totalHours.plus(record.getHoursWorked());
        }

        return totalHours;
    }
    //to print all attendance records for an employee
    public void printRecords(int employeeId){
        List<AttendanceRecord> records = attendanceRecords.getOrDefault(employeeId, new ArrayList<>());

        if (records.isEmpty()){
            System.out.println("No Attendance records found fo Employee" + employeeId);
        }else{
            System.out.println("The Employee record for "+employeeId+":");
            for (AttendanceRecord record : records){
                System.out.println(record);
        }
        
       
        }
    }
    
}
