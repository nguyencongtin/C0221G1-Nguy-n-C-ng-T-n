package model.repository;

import model.bean.AttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository {
    BaseRepository baseRepository = new BaseRepository();
    public List<AttachService> findByAll() {
            Connection connection = baseRepository.connectDataBase();
            List<AttachService> attachServiceList = new ArrayList<>();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select* from dich_vu_di_kem");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int attachServiceId = resultSet.getInt("id_dich_vu_di_kem");
                    String attachServiceName = resultSet.getString("ten_dich_vu_di_kem");
                    double attachServiceCost = resultSet.getDouble("gia");
                    int attachServiceUnit = resultSet.getInt("don_vi");
                    String attachServiceStatus = resultSet.getString("trang_thai_kha_dung");
                    AttachService attachService = new AttachService(attachServiceId, attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus);
                    attachServiceList.add(attachService);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return attachServiceList;
        }
    }
