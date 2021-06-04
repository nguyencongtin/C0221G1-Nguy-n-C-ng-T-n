package model.repository;

import model.bean.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

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
            callableStatement.setInt("p_so_nguoi_toi_da",service.getServiceMaxPeople());
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
}

