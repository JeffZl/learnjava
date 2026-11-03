public class Student {
    private String name;
    private String studentId;
    private int age;
    private double gpa;

    public Student(String stName, String stId, int stAge, double stGpa ) {
        this.name = stName;
        this.studentId = stId;
        this.age = stAge;
        this.gpa = stGpa;
    }

    public String getStudentId(){
        return this.studentId;
    }

    public void setGpa(double newGpa){
        this.gpa = newGpa;
    }

    public void displayInfo(){
        System.out.println("Student Information");
        System.out.println("-------------------");
        System.out.println("Name: " + this.name);
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Age: " + this.age);
        System.out.println("GPA: " + this.gpa);
    }
}