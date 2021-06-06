package model.repository;

import model.bean.Service;
import model.bean.TypeRent;
import model.bean.TypeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    public boolean addNewService(Service service) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call create_service(?,?,?,?,?,?,?,?,?,?)}");
            callableStatement.setString("p_ten_dich_vu", service.getServiceName());
            callableStatement.setInt("p_dien_tich", service.getServiceArea());
            callableStatement.setInt("p_so_tang", service.getNumberOfFloor());
            callableStatement.setInt("p_so_nguoi_toi_da", service.getServiceMaxPeople());
            callableStatement.setDouble("p_chi_phi_thue", service.getServiceCost());
            callableStatement.setInt("p_id_kieu_thue", service.getRentTypeId());
            callableStatement.setInt("p_id_loai_dich_vu", service.getServiceTypeId());
            callableStatement.setString("p_trang_thai", service.getDescriptionOtherConverience());
            callableStatement.setDouble("p_dien_tich_ho_boi", service.getPoolArea());
            callableStatement.setString("p_kieu_phong", service.getStandardRoom());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Service> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from dich_vu");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idService = resultSet.getInt("id_dich_vu");
                String serviceName = resultSet.getString("ten_dich_vu");
                int serviceArea = resultSet.getInt("dien_tich");
                int numberOfFloor = resultSet.getInt("so_tang");
                int serviceMaxPeople = resultSet.getInt("so_nguoi_toi_da");
                double serviceCost = resultSet.getDouble("chi_phi_thue");
                int rentTypeId = resultSet.getInt("id_kieu_thue");
                int serviceTypeId = resultSet.getInt("id_loai_dich_vu");
                String standardRoom = resultSet.getString("kieu_phong");
                String descriptionOtherConverience = resultSet.getString("trang_thai");
                double poolArea = resultSet.getDouble("dien_tich_ho_boi");
                Service service= new Service(idService,serviceName,serviceArea,numberOfFloor,serviceMaxPeople,serviceCost,rentTypeId,serviceTypeId,standardRoom,descriptionOtherConverience,poolArea);
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    public List<TypeRent> findByAllTypeRent() {
        Connection connection = baseRepository.connectDataBase();
        List<TypeRent> typeRentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from kieu_thue");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id_kieu_thue");
                String name=resultSet.getString("ten_kieu_thue");
                int cost=resultSet.getInt("gia");
                typeRentList.add(new TypeRent(id,name,cost));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeRentList;
    }

    public List<TypeService> findByAllTypeService() {
        Connection connection = baseRepository.connectDataBase();
        List<TypeService> typeServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from loai_dich_vu");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id_loai_dich_vu");
                String name=resultSet.getString("ten_loai_dich_vu");
                typeServiceList.add(new TypeService(id,name));
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeServiceList;
    }
}