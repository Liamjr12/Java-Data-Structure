package GradingSystem;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class GradeManager {

    Map<String, Integer> gradeManager = new LinkedHashMap<>();

    private String addStudent(Scanner scanner) {
        System.out.print("\nAdd name: ");
        String name = scanner.nextLine();
        return name;
    }

    public void addGrade(Scanner scanner) {
        String name = addStudent(scanner);

        System.out.print("Add grade: ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        gradeManager.put(name, grade);

    }

    public void displayGrade() {
        int i = 1; 
        System.out.println("\n======= STUDENT GRADE LIST =======");
        for (Map.Entry<String, Integer> entry : gradeManager.entrySet()) {
            System.out.println((i++) + ". " + entry.getKey() + "->" + entry.getValue());
        }
    }

    public void findStudent(Scanner scanner) {
        System.out.print("\nSearch: ");
        String name = scanner.nextLine();
        isFound(name);
    }

    public void updateGrade(Scanner scanner) {
        System.out.print("\nSearch: ");
        String name = scanner.nextLine();
        
        if (isFound(name)) {
            System.out.print("Update: ");
            int grade = scanner.nextInt();
            gradeManager.put(name, grade);
        } 
        
    }

    public void removeStudent(Scanner scanner) {
        System.out.print("\nRemove: ");
        String name = scanner.nextLine();

        if (gradeManager.containsKey(name)) {
            gradeManager.remove(name);
        } else {
            isNotFound();
        }

    }

    @SuppressWarnings("unused")
    private boolean isFound(String name) {
        for (String key : gradeManager.keySet()) {
            if (gradeManager.containsKey(name)) {
                System.out.println("Student " + name + " has been found");
                return true;
            } 
            
        }
        isNotFound();
        return false;
    }

    private void isNotFound() {
        System.out.println("Student is not on the list");
    }

}
