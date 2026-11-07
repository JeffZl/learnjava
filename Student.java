public class Student {
    private String name;
    private String studentId;
    private int age;
    private double gpa;
    private StudentStatus status;

    public Student(String stName, String stId, int stAge, double stGpa, StudentStatus status) {
        this.name = stName;
        this.studentId = stId;
        this.age = stAge;
        this.gpa = stGpa;
        this.status = status;
    }

    public String getStudentId(){
        return this.studentId;
    }

    public void setGpa(double newGpa){
        this.gpa = newGpa;
    }

    public double getGpa(){
        return this.gpa;
    }

    public String getName(){
        return this.name;
    }

    public StudentStatus getStatus(){
        return this.status;
    }
    
    public void displayInfo(){
        System.out.println("Student Information");
        System.out.println("-------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Age: " + this.age);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Status: " + this.status);
    }
}