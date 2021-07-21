package bai5_AccessModifierStaticMethodStaticProperty.thuc_hanh.AccessModifier.Private;

public class Test {
    public class A {
        private int data = 40;

        void msg() {
            System.out.println("Hello java");
        }

    }
    public static class Simple {
        public static void main(String args[]){
            bai5_AccessModifierStaticMethodStaticProperty.thuc_hanh.AccessModifier.Private.A obj=new bai5_AccessModifierStaticMethodStaticProperty.thuc_hanh.AccessModifier.Private.A();
            System.out.println(obj.data);
            obj.msg();
        }
    }

}
