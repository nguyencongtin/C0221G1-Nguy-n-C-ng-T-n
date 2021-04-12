package com.bai10.bai_tap.trienKhaiPhuongThucCuaLinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        class Student{
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList= new MyLinkedList<>();
        Student student1= new Student(1,"Tín");
        Student student2= new Student(2,"Linh");
        Student student3= new Student(3,"Anh");
        Student student4= new Student(4,"Huyên");
        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(2,student4);
        MyLinkedList<Student> cloneLinkedList= myLinkedList.clone();
        for (int i=0;i<myLinkedList.size();i++){
            Student student=(Student)myLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
