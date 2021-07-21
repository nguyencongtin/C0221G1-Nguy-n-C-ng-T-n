package bai17_IOBinaryFileSerialization.bai_tap.copyFileNhiPhan;
import java.io.*;
import java.util.Scanner;

public class CopyFile {


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhập đường dẫn cần copy");
        String b= sc.nextLine();
         File path1 = new File(b);
        System.out.println("Nhập tập đích cần copy");
        String c= sc.nextLine();
         File path2 = new File(c);
        int count=0;
        try {
            FileInputStream is = new FileInputStream(path1);
            FileOutputStream os = new FileOutputStream(path2,true);
            byte[] buffer = new byte[1024];
            int length;
//            while ((length = is.read(buffer)) > 0) {
//                os.write(buffer, 0, length);
//
//            }
            while ((length = is.read()) >0){
                os.write(length);
                count++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of byte in File: "+count);
    }
}