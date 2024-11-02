package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.Course;
import model.Student;

public class StudentService {
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Student findStudent(String studentId) {
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }

    public boolean isSubscribed(String studentId) {
        // TODO implement this method

        if (students.containsKey(studentId)) {
            return true;
        }
        return false;
    }

    public void showSummary() {
        // TODO implement

        Set<String> keys = students.keySet();
        for (String value : keys) {

            Student stud = students.get(value);
            System.out.println(stud);
            System.out.println();
        }

    }

    public void enrollToCourse(String studentId, Course course) {
        if (students.containsKey(studentId)) {
            students.get(studentId).enrollToCourse(course);
        } else
            System.out.println("Please enroll student first thank you...!");
    }

    public double calculateAverageGradeForCourse(Course course) {

        if (!students.isEmpty()) {

            int totalGrades = 0;
            int studentCount = 0;

            Set<String> keys = students.keySet();

            for (String key : keys) {

                if (students.get(key).isAttendingCourse(course.getCode())) {
                    Integer grade = students.get(key).getCourseGrade(course);
                    if (grade != null) {
                        totalGrades += grade;
                        studentCount++;
                    }
                }
            }
            return studentCount > 0 ? (double) totalGrades / studentCount : 0.0;
        } else
            System.out.println("There is no Students");

        return 0.0;

    }

}
