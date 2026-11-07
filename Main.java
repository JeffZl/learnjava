import java.util.*;

public class Main {
    public static <T> void printArray(T[] value){
        for(int i = 0; i < value.length; i++){
            System.out.println(value[i]);
        }
    }

    public static <T> T getFirst(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty!");
        }

        return array[0];
    }

    public static Student findStudent(HashMap<String, Student> students, String studentId) {
        // for (Student student: students) {
        //     if(student.getStudentId().equals(studentId)){
        //         return student;
        //     }
        // }
        return students.get(studentId);
    }

    public static void displayStudent(HashMap<String, Student> students){
        for(Student student: students.values()) {
            student.displayInfo();
        }
    }

    public static void addStudent(HashMap<String, Student> students, Scanner scanner){
        System.out.print("Insert student name: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();

        System.out.print("Insert student ID: ");
        String studentId4 = scanner.next();

        System.out.print("Insert student age: ");
        int studentAge = scanner.nextInt();

        System.out.print("Insert student GPA: ");
        double studentGpa = scanner.nextDouble();

        System.out.println("\n1. ACTIVE");
        System.out.println("2. INACTIVE");
        System.out.println("3. GRADUATED");
        System.out.println("Choose student status:");
        int statusNum = scanner.nextInt();



        Student existingStudent = findStudent(students, studentId4);

        if (existingStudent != null) {
            System.out.println("Student ID already exists!");
        } else if (studentName.isBlank() || studentAge <= 0) {
            throw new IllegalArgumentException("Invalid student information!");
        } else {
            try {
                validateGpa(studentGpa);

                if(statusNum > StudentStatus.values().length || statusNum <= 0) {
                    throw new IllegalArgumentException("Value must be in range of 1-" + StudentStatus.values().length);
                }

                StudentStatus status = StudentStatus.values()[statusNum - 1];

                students.put(studentId4, new Student(studentName, studentId4, studentAge, studentGpa, status));
                System.out.println("Student successfully added!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void updateStudentGpa(HashMap<String, Student> students, Scanner scanner) {
        System.out.print("Insert student ID: ");
        String studentId2 = scanner.next();
        Student student = findStudent(students, studentId2);

        if(student != null) {
            System.out.print("Insert new GPA: ");
            double newGpa = scanner.nextDouble();

            try{
                validateGpa(newGpa);
                student.setGpa(newGpa);
                student.displayInfo();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Student not found! Please try again.");
        }
    }

    public static void deleteStudent(HashMap<String, Student> students, Scanner scanner){
        System.out.print("Insert student ID: ");
        String studentId3 = scanner.next();
        Student student3 = findStudent(students, studentId3);

        if(student3 != null) {
            students.remove(studentId3);
            System.out.println("Student successfully deleted!");
        } else {
            System.out.println("Student not found! Please try again.");
        }
    }

    public static void searchStudent(HashMap<String, Student> students, Scanner scanner){
        System.out.print("Insert student ID: ");
        String studentId = scanner.next();
        Student foundStudent = findStudent(students, studentId);

        if(foundStudent != null) {
            foundStudent.displayInfo();
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void removeLowGpaStudents(HashMap<String, Student> students) {
        Iterator<Student> iterator = students.values().iterator();

        int removedCount = 0;

        while(iterator.hasNext()) {
            Student student = iterator.next();

            if (student.getGpa() < 2.0) {
                System.out.println(student.getName() + " is removed from the list");
                iterator.remove();
                removedCount += 1;
            }
        }

        System.out.println("The total amount of students that are removed: " + removedCount);
    }

    public static void validateGpa(double gpa){
        if(gpa < 0.00 || gpa > 4.00) {
            throw new IllegalArgumentException("GPA must be in the range of 0.00-4.00");
        }
    }

    public static <T> void displayList(ArrayList<T> list){
        for(T item: list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        StudentStatus status = StudentStatus.ACTIVE;
        System.out.println(status);

        String[] names = {"Alex", "Sarah", "John"};
        Integer[] numbers = {10, 20, 30};
        printArray(names);
        printArray(numbers);

        HashMap<String, Student> students = new HashMap<>();
        students.put("10001", new Student("Alex", "10001", 21, 3.75, StudentStatus.ACTIVE));
        students.put("10002", new Student("Sarah", "10002", 20, 1.50, StudentStatus.ACTIVE));
        students.put("10003", new Student("John", "10003", 22, 3.45, StudentStatus.GRADUATED));
        students.put("10004", new Student("David", "10004", 21, 1.80, StudentStatus.ACTIVE));
        students.put("10005", new Student("Emily", "10005", 23, 3.85, StudentStatus.GRADUATED));

//        try {
//            Student firstStudent = getFirst(students);
//            firstStudent.displayInfo();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        removeLowGpaStudents(students);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("========== STUDENT MANAGEMENT SYSTEM ==========\n");
            System.out.println("1. View all students");
            System.out.println("2. Search student");
            System.out.println("3. Update student GPA");
            System.out.println("4. Delete student");
            System.out.println("5. Add student");
            System.out.println("0. Exit\n");

            int choice = -1;
            System.out.print("Choose an option: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }

            if (choice != -1) {
                switch (choice) {
                    case 1:
                        System.out.println("Viewing all students...");
                        displayStudent(students);
                        break;

                    case 2:
                        searchStudent(students, scanner);
                        break;

                    case 3:
                        updateStudentGpa(students, scanner);
                        break;

                    case 4:
                        deleteStudent(students, scanner);
                        break;

                    case 5:
                        addStudent(students, scanner);
                        break;

                    case 0:
                        System.out.println("Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args){
//        Box<String> nameBox = new Box<>("Alex");
//
//        System.out.println(nameBox.getValue()); // Alex
//
//        nameBox.setValue("Sarah");
//
//        System.out.println(nameBox.getValue()); // Sarah
//
//        Pair<String, Double> studentRecord =
//                new Pair<>("10001", 3.75);
//
//        System.out.println(studentRecord.getKey());   // 10001
//        System.out.println(studentRecord.getValue()); // 3.75
//
//        studentRecord.setValue(3.90);
//
//        System.out.println(studentRecord.getValue()); // 3.9
//
//        StudentStatus status = StudentStatus.ACTIVE;
//
//        System.out.println(status);
//    }
//}