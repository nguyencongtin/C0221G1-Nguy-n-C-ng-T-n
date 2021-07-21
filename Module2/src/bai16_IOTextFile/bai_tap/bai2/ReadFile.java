package bai16_IOTextFile.bai_tap.bai2;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            String string = "src\\com\\bai16_IOTextFile\\bai19_StringRegex.bai_tap\\bai2_LoopInJava\\WriteFile.csv";
            FileWriter fileWriter = new FileWriter(string);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str= "\"1.0.0.0\",\"1.0.0.255\",\"16777216\",\"16777471\",\"AU\",\"Australia\"\n" +
                    "\"1.0.1.0\",\"1.0.3.255\",\"16777472\",\"16778239\",\"CN\",\"China\"\n" +
                    "\"1.0.4.0\",\"1.0.7.255\",\"16778240\",\"16779263\",\"AU\",\"Australia\"\n" +
                    "\"1.0.8.0\",\"1.0.15.255\",\"16779264\",\"16781311\",\"CN\",\"China\"\n" +
                    "\"1.0.16.0\",\"1.0.31.255\",\"16781312\",\"16785407\",\"JP\",\"Japan\"\n" +
                    "\"1.0.32.0\",\"1.0.63.255\",\"16785408\",\"16793599\",\"CN\",\"China\"\n" +
                    "\"1.0.64.0\",\"1.0.127.255\",\"16793600\",\"16809983\",\"JP\",\"Japan\"\n" +
                    "\"1.0.128.0\",\"1.0.255.255\",\"16809984\",\"16842751\",\"TH\",\"Thailand\"";
            bufferedWriter.write(str);
            bufferedWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(string));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] string1 = line.split(",");
                System.out.println(string1[string1.length - 1]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
