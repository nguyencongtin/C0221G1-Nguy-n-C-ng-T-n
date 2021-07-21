package baiThi.commons;

import baiThi.controllers.DanhMuc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GhiDocFile {
    public static final String PATH = "D:\\C0221G1NguyenCongTin\\Module2\\src\\baiThi\\data\\";
    public static void ghiFile (String fileName, List<DanhMuc> danhMucList, boolean trangThai){
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            file = new File(PATH+fileName);
            fileWriter = new FileWriter(file,trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (DanhMuc danhMuc : danhMucList){
                bufferedWriter.write(danhMuc.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
                fileWriter.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> docFile(String fileName){
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<String> stringList =  new ArrayList<>();
        String line = null;
        try{
            file = new File(PATH+fileName);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine())!= null){
                stringList.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return stringList;
    }
}