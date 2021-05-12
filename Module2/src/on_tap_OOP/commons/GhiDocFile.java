package on_tap_OOP.commons;



import on_tap_OOP.models.CanBo;
import on_tap_OOP.models.CongNhan;
import on_tap_OOP.models.KySu;
import on_tap_OOP.models.NhanVien;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GhiDocFile {
    public static final String PATH = "D:\\C0221G1NguyenCongTin\\Module2\\src\\on_tap_OOP\\data\\";
    public static void ghiFile (String fileName, List<CanBo> canBoList, boolean trangThai){
        File file = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            file = new File(PATH+fileName);
            fileWriter = new FileWriter(file,trangThai);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (CanBo canBo : canBoList){
                bufferedWriter.write(canBo.toString());
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
    public static List<CanBo> docFile(String fileName){
        File file = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<CanBo> canBoList = new ArrayList<>();
        String line = null;
        String[] strings = null;
        try{

            file = new File(PATH+fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine())!= null){
                strings = line.split(",");
                if (strings[5].contains("/7")){
                    CanBo congNhan= new CongNhan(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5]);
                    canBoList.add(congNhan);
                }else if(strings[5].contains("PV")){
                    CanBo nhanVien = new NhanVien(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5]);
                    canBoList.add(nhanVien);
                }else {
                    CanBo kySu = new KySu(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5]);
                    canBoList.add(kySu);
                }
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
        return canBoList;
    }

    public static List<String> docFileNganhDaoTao(String fileName){
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