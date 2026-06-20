package ClassroomAttendanceTracker;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class Classroom {

    private Set<String> registeredStudents = new LinkedHashSet<>();
    private Set<String> presentStudents = new LinkedHashSet<>();
    private Set<String> absentStudents = new LinkedHashSet<>();
    
    public void addStudent(Scanner scanner) {
        System.out.print("\nAdd student: ");
        String line = scanner.nextLine().trim().toLowerCase();

        if (line.isBlank()) {
            printError();
            return;
        }

        if (!registeredStudents.add(line)) {
            System.out.println("This student is already registered");
            return;
        } 
        
        registeredStudents.add(line);
        System.out.println("Student \'" + line + "\' has been registered");

    }

    public void markAttendance(Scanner scanner) {
        System.out.print("\nStudent: ");
        String student = scanner.nextLine().trim().toLowerCase();

        if (presentStudents.contains(student) || absentStudents.contains(student)) {
            System.out.println("Student \'" + student + "\' is already marked");
            return;
        }

        if (registeredStudents.contains(student)) {
            System.out.print("Attendance: ");
            String line = scanner.nextLine().trim().toLowerCase();

            if (line.equals("present")) {
                presentStudents.add(student);
                System.out.println("Student \'" + student + "\' is marked as present inside the class");
            } else if (line.equals("absent")) {
                absentStudents.add(student);
                System.out.println("Student \'" + student + "\' is marked as absent" );
            } else {
                printError();
            }

        } else {
            System.out.println("Student \'" + student + "\' is not on the list");
        }

    }

    public void displayRegisteredStudents() {
        Iterator<String> it = registeredStudents.iterator();
        int i = 1;

        if (registeredStudents.isEmpty()) {
            System.out.println("\nRegistered list is empty");
            return;
        }

        System.out.println("\n======== Registered Students ========");
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }

    }

    public void displayPresentStudents() {
        Iterator<String> it = presentStudents.iterator();
        int i = 1;

        if (presentStudents.isEmpty()) {
            System.out.println("\nPresent attendance is empty");
            return;
        }

        System.out.println("\n======== Present Students ========");
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }

    }

    public void displayAbsentStudents() {
        Iterator<String> it = absentStudents.iterator();
        int i = 1;

         if (absentStudents.isEmpty()) {
            System.out.println("\nAbsent attendance is empty");
            return;
        }

        System.out.println("\n======== Absent Students ========");
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }

    }

    public void displayAttendance() {
        if (presentStudents.isEmpty() && absentStudents.isEmpty()) {
            System.out.println("\nThe attendance is currently empty");
            return;
        } 
        
        displayPresentStudents();
        displayAbsentStudents();

    }

    private void printError() {
        System.out.println("Invalid input");
        System.out.println("Please re-enter your credentials");
    }

}