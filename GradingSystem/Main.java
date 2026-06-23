package GradingSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GradeManager gradeManager = new GradeManager();

        while (true) {
            try {
                dashBoard();
                System.out.print("\nChoice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice) {
                    case 1 -> gradeManager.addGrade(scanner);
                    case 2 -> gradeManager.displayGrade();
                    case 3 -> gradeManager.findStudent(scanner);
                    case 4 -> gradeManager.updateGrade(scanner);
                    case 5 -> gradeManager.removeStudent(scanner);
                    case 6 -> {
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid input");
                }


            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
            }
        }

    }

    public static void dashBoard() {
        System.out.print("""
        \n======= STUDENT MANAGEMENT SYSTEM =======
        1. Add student
        2. View grades
        3. Search student
        4. Update grade
        5. Remove student
        6. Exit    
        """);
    }
    
}
