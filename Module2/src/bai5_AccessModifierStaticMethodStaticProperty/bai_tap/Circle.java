package bai5_AccessModifierStaticMethodStaticProperty.bai_tap;

public class Circle {
    private double radius=1;
    private String color="red";

    public Circle() {
    }
    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }
    public double aRea(){
        return (Math.PI*this.radius*this.radius);
    }

}
