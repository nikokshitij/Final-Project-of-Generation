package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.*;

import model.Student;

;

public class PrinterHelper {

    public static void showMainMenu() {
        System.out.println("|-------------------------------|");
        System.out.println("| Welcome to StudentGen         |");
        System.out.println("|-------------------------------|");
        System.out.println("| Select 1 option:              |");
        System.out.println("| . 1 Register Student          |");
        System.out.println("| . 2 Find Student              |");
        System.out.println("| . 3 Grade Student             |");
        System.out.println("| . 4 Enroll Student to Course  |");
        System.out.println("| . 5 Show Students Summary     |");
        System.out.println("| . 6 Show Courses Summary      |");
        System.out.println("| . 7 Exit                      |");
        System.out.println("|-------------------------------|");
    }

    public static Student createStudentMenu(Scanner scanner)
            throws ParseException {
        System.out.println("|-------------------------------------|");
        System.out.println("| . 1 Register Student                |");
        System.out.println("|-------------------------------------|");
        System.out.println("| Enter student name:                 |");
        String name = scanner.next();
        System.out.println("| Enter student ID:                   |");
        String id = scanner.next();
        System.out.println("| Enter student email:                |");
        String email = scanner.next();

        // TODO validate date format and catch exception to avoid crash

        Date birthDate = null;

        while (true) {
            try {
                System.out.println("| Enter student birth date(mm/dd/yyyy)|");
                SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
                birthDate = formatter.parse(scanner.next());
                break;

            } catch (Exception e) {
                // TODO: handle exception
                System.err.println("Please Enter birth date in valid formate");
                // createStudentMenu(scanner);
            }
        }
        System.out.println("|-------------------------------------|");
        Student student = new Student(id, name, email, birthDate);
        System.out.println("Student Successfully Registered! ");
        System.out.println(student);
        return student;
    }

}