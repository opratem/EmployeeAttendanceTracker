import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // Create an instance of the AttendanceTracker class
        AttendanceTracker tracker = new AttendanceTracker();

        // Allow user to enter multiple attendance records
        int employeeId = addRecordsFromUser(tracker);

        // Print the attendance records for the entered employee
        tracker.printRecords(employeeId);

        // Calculate and print total hours worked by the entered employee
        Duration totalHours = tracker.getTotalHoursWorked(employeeId);
        System.out.println("The Total Hours Worked by Employee " + employeeId + ": " + totalHours.toHours() + " hours");
    }

    // Method to allow user to input multiple attendance records
    public static int addRecordsFromUser(AttendanceTracker tracker) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        boolean continueAdding = true;

        // Loop to add multiple records
        while (continueAdding) {
            LocalDateTime checkIn = getDateTimeFromUser(scanner, "Check-In");
            LocalDateTime checkOut = getDateTimeFromUser(scanner, "Check-Out");

            tracker.addRecord(employeeId, checkIn, checkOut);
            System.out.println("Attendance record added successfully!");

            // Ask if the user wants to enter another record
            System.out.print("Do you want to add another record? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("no")) {
                continueAdding = false;
            }
        }

        return employeeId;
    }

    // Helper method to get date-time input from user
    private static LocalDateTime getDateTimeFromUser(Scanner scanner, String type) {
        System.out.print("Enter " + type + " Time (yyyy-MM-dd HH:mm): ");
        String dateTimeInput = scanner.nextLine().trim();

        // Ensure the format is always "yyyy-MM-dd HH:mm" (leading zeros for hours/minutes)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:mm");

        return LocalDateTime.parse(dateTimeInput, formatter);
    }
}
