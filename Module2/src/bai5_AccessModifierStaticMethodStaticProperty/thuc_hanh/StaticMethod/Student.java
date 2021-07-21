package bai5_AccessModifierStaticMethodStaticProperty.thuc_hanh.StaticMethod;

public class Student {
    private int rollno;
    private String name;
    private static String college;

    //constructor to initialize the variable
    Student(int r, String n) {
        this.rollno = r;
        this.name = n;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODEGYM";
    }

    //method to display values
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}
