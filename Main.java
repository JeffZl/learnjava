
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "10001", 21, 3.75));
        students.add(new Student("Sarah", "10002", 20, 3.90));
        students.add(new Student("John", "10003", 22, 3.45));
        students.add(new Student("David", "10004", 21, 3.65));
        students.add(new Student("Emily", "10005", 23, 3.85));

        System.out.println("Total Students: " + students.size());
        
        boolean found = false;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        // for (Student student : students){
        //     if(student.getStudentId().equals("10006")){
        //         student.displayInfo();
        //         found = true;
        //     }
        // }
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getStudentId().equals(id)){
                // students.remove(i);
                students.get(i).setGpa(3.80);
                found = true;
                students.get(i).displayInfo();
                // System.out.println("Total Students after 10003 removed: " + students.size());
            }
            
        }
        if(!found) System.out.println("Student not found!");
    }
}