import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class list {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> arr_book = new ArrayList<>();
        List<String> linked_book = new LinkedList<>();

        while (true) {
            dashBoard();
            System.out.print("INPUT >> ");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add -b":
                    arr_book.add(addBookOperation(scanner));
                    break;
                case "view -b":
                    displayBookOperation(arr_book);
                    break;
                case "br -b":
                    borrowBookOperation(scanner, arr_book, linked_book);
                    break;
                case "rt -b":
                    returnBookOperation(scanner, arr_book, linked_book);
                    break;
                case "find -b":
                    searchBookOperation(scanner, arr_book, linked_book);
                    break;
                case "view -br -b":
                    viewBorrowedBookOperation(linked_book);
                    break;
                case ":wq":
                    scanner.close();
                    return;
                case "--help":
                    showHelp();
                    break;
                default:
                    undefinedInput();
                    break;
            }

        }
        
    }   

    public static final void dashBoard() {
        System.out.println("""
        \n======= LIBRARY SYSTEM =======
        1. Add book
        2. View books
        3. Borrow book
        4. Return book
        5. Search book
        6. View borrowed book
        7. Exit
        """);
    }

    public static final void undefinedInput() {
        System.out.println("""
        \n======= ERROR MESSAGE =======
        Invalid input
        Type --help to view available commands
        Please re-enter your command
        """);
    }

    public static void showHelp() {
    System.out.println("""
    \n======= COMMAND REFERENCE =======
    
    COMMAND      | DESCRIPTION
    -------------|------------------------------------------
    add -b       | Add a new book to the library
    view -b      | Display all books in the library
    br -b        | Borrow a book from the library
    rt -b        | Return a borrowed book
    find -b      | Search for a book by title/author
    view -br -b  | Show all currently borrowed books
    :wq           | Exit the library system    
        """);
    }

    public static String addBookOperation(Scanner scanner) {
        while (true) {
            System.out.print("Add book >> ");
            String input = scanner.nextLine();

            if (input.isBlank() || input.length() < 2) {
                System.out.println("The book you're trying to add is invalid");
                System.out.println("Please re-enter your operation");
                continue;
            } 

            System.out.println("Book " + "\"" +input + "\"" +" has been added");
            return input;
        }
    }

    public static void displayBookOperation(List<String> arraylist) {
        System.out.println("\n======= BOOK LIST SUMMARY =======");
        Iterator<String> it = arraylist.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }
    }

    public static void borrowBookOperation(Scanner scanner, List<String> arraylist, List<String> linkedlist) {
        while (true) {
            System.out.print("Borrow book >> ");
            String line = scanner.nextLine();

            if (arraylist.contains(line)) {
                arraylist.remove(line);
                linkedlist.add(line);
                System.out.println(line + " has been borrowed");
            } else if (linkedlist.contains(line)) {
                System.out.println("The book " + line + " is currently borrowed by others");
            } else if (line.equalsIgnoreCase(":q")){
                break;
            } else {
                System.out.println("Invalid input");
                System.out.println("We only let users borrow books from our library");
                System.out.println("Please re-enter your operation");
                continue;
            }

        }
    }

    public static void returnBookOperation(Scanner scanner, List<String> arraylist, List<String> linkedlist) {
        while (true) {
            System.out.print("Return book >> ");
            String line = scanner.nextLine();

            if (linkedlist.contains(line)) {
                linkedlist.remove(line);
                arraylist.add(line);
                System.out.println("The book " + line + " has been successfuly returned");
                continue;   
            } else if (line.equalsIgnoreCase(":q")){
                break;
            } else {
                System.out.println("Invalid input");
                System.out.println("We only accept a book that has been borrowed from our library");
                System.out.println("Please re-enter your operation");
                continue;
            }
            
        }
    }

    public static void searchBookOperation(Scanner scanner, List<String> arraylist, List<String> linkedlist) {
        while (true) {
            System.out.print("Search book >> ");
            String line = scanner.nextLine();

            if (arraylist.contains(line)) {
                System.out.println("The book you are looking " + line + " is currently available inside the library");
                continue;   
            } else if (linkedlist.contains(line)) {
                System.out.println("The book you are looking " + line + " is currently being borrowed");
                continue;
            } else if (line.equalsIgnoreCase(":q")){
                break;
            } else {
                System.out.println("Invalid input");
                System.out.println("Please re-enter your operation");
                continue;
            }
            
        }
    }

    public static void viewBorrowedBookOperation(List<String> linkedlist) {
        System.out.println("======= BORROWED BOOKS SUMARY =======");
        Iterator<String> it = linkedlist.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }
    }

}