package bai6_Inheritance.bai_tap.Bai3;

public class MoveablePoint extends Point {
    private float xSpeed=0.0f;
    private float ySpeed=0.0f;

    public MoveablePoint(float x, float y,float xSpeed,float ySpeed) {
        super(x, y);
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        float[] arr=new float[2];
        arr[0]=xSpeed;
        arr[1]=ySpeed;
    }
    public float [] getSpeed(){
        float[] arr={this.xSpeed,this.ySpeed};
        return arr;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
       Point point= new Point(4,4);
       point=new MoveablePoint(point.x,point.y,3,4);
        System.out.println(point);
    }
}
