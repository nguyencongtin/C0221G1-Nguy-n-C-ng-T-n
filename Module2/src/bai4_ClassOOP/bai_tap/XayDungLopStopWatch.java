package bai4_ClassOOP.bai_tap;

import java.util.Arrays;

public class XayDungLopStopWatch {
    private double startTime;
    private double endTime;
public XayDungLopStopWatch (double startTime,double endTime){
    this.startTime=startTime;
    this.endTime=endTime;
}
public XayDungLopStopWatch(){

}
    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }
    public double startTime(){
        startTime=System.currentTimeMillis();
        return startTime;
    }
    public double endTime(){
        endTime=System.currentTimeMillis();
        return endTime;
    }
    public double getElapsedTime() {
        return endTime-startTime;
    }

    public static void main(String[] args) {
        XayDungLopStopWatch s= new XayDungLopStopWatch();
        int [] arr=new int [10000];
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*1000);
        }
        s.startTime();
        Arrays.sort(arr);
        s.endTime();
        System.out.println("Thời gian đã trôi qua: " +s.getElapsedTime());
}
}


