package bai16.bai_tap.bai1;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String string1 = "src\\com\\bai16\\bai19.bai_tap\\bai2\\WriteFile.csv";
        String string2 = "src\\com\\bai16\\bai19.bai_tap\\bai1\\CopyFile";
        try {
            BufferedReader bufferedReader= new BufferedReader(new FileReader(string1));
            BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(string2));
            String line;
            while((line=bufferedReader.readLine())!=null){
                bufferedWriter.append(line);
                bufferedWriter.newLine();
//                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            BufferedReader bufferedReader1= new BufferedReader(new FileReader(string2));
            String line1;
            while ((line1=bufferedReader1.readLine())!=null){
                System.out.println(line1);
            }
            bufferedReader1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
