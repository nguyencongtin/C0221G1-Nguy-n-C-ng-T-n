package bai10_DSADanhSach.bai_tap.trienKhaiPhuongThucCuaArrayList;

public class TestMyArrayList {
    static class Student {
        private int id;
        private String name;
        public Student(){
        }
        public Student(int id, String name){
            this.id=id;
            this.name= name;
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
        public static void main(String[] args) {
        Student a= new Student(1,"Huy");
        Student b= new Student(2,"Hoàng");
        Student c= new Student(3,"Tín");
        Student d= new Student(4,"Linh");
        Student e= new Student(5,"Oanh");
        MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
        studentMyArrayList.add(a);
        studentMyArrayList.add(b);
        studentMyArrayList.add(c);
        studentMyArrayList.add(d);
        studentMyArrayList.add(e);
            for (int i =0;i< studentMyArrayList.size();i++) {
                Student student = (Student)studentMyArrayList.elements[i];
                System.out.println(student.getId());
                System.out.println(student.getName());
            }
        }
    }
}
