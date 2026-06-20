package ClassroomAttendanceTracker;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Classroom classroom = new Classroom();

        while (true) {
            try {
                dashBoard();
                System.out.print("Choice: ");
                int line = scanner.nextInt();
                scanner.nextLine();

                switch (line) {
                    case 1:
                        classroom.addStudent(scanner);
                        break;
                    case 2:
                        classroom.markAttendance(scanner);
                        break;
                    case 3:
                        classroom.displayRegisteredStudent();
                        break;
                    case 4:
                        classroom.displayPresentStudent();
                        break;
                    case 5: 
                        classroom.displayAbsentStudent();
                        break;
                    case 6:
                        classroom.displayAttendance();
                        break;
                    case 7:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1-7.");
                        break;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                scanner.nextLine();
            }
            
        }
    }

    public static void dashBoard() {
        System.out.println("""
        \n======== CLASSROOM ATTENDANCE TRACKER ========
        1. Register student
        2. Mark attendance
        3. View registered student
        4. View present student
        5. View absent student
        6. Check attendance
        7. Exit
        """);
    }

}
