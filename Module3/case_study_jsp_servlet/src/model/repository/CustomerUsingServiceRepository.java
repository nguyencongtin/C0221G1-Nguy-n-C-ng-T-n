package model.repository;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.Customer;
import model.bean.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingServiceRepository {
    BaseRepository baseRepository= new BaseRepository();
    public List<Customer> findByAllCustomerUsingService() {
        Connection connection = baseRepository.connectDataBase();
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select kh.id_khach_hang,ho_ten,ngay_sinh,sdt\n" +
                    "from khach_hang kh\n" +
                    "join hop_dong hd on hd.id_khach_hang= kh.id_khach_hang\n" +
                    "where date(now()) < ngay_ket_thuc\n" +
                    "group by hd.id_khach_hang;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            int idCustomer= resultSet.getInt("kh.id_khach_hang");
            String customerName=resultSet.getString("ho_ten");
            String birthday=resultSet.getString("ngay_sinh");
            String phone=resultSet.getString("sdt");
            customerList.add(new Customer(idCustomer,customerName,birthday,phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public List<AttachService> findByAllAttachService(int id) {
        Connection connection = baseRepository.connectDataBase();
        List<AttachService> attachServiceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select dvdk.id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung,ngay_lam_hop_dong,ngay_ket_thuc,hd.id_hop_dong\n" +
                    "from dich_vu_di_kem dvdk\n" +
                    "join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem\n" +
                    "join hop_dong hd on hd.id_hop_dong= hdct.id_hop_dong \n" +
                    "where date(now()) < ngay_ket_thuc and id_khach_hang=?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId=resultSet.getInt("hd.id_hop_dong");
                int attachServiceId = resultSet.getInt("id_dich_vu_di_kem");
                String attachServiceName = resultSet.getString("ten_dich_vu_di_kem");
                double attachServiceCost = resultSet.getDouble("gia");
                int attachServiceUnit = resultSet.getInt("don_vi");
                String attachServiceStatus = resultSet.getString("trang_thai_kha_dung");
                String contractStartDate= resultSet.getString("ngay_lam_hop_dong");
                String contractEndDate=resultSet.getString("ngay_ket_thuc");
                AttachService attachService = new AttachService(contractId,attachServiceId, attachServiceName, attachServiceCost, attachServiceUnit, attachServiceStatus,contractStartDate,contractEndDate);
                attachServiceList.add(attachService);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServiceList;

    }

    public boolean deleteContract(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hop_dong where id_hop_dong=?");
            preparedStatement.setInt(1, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateContract(int id, Contract contract) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update hop_dong \n" +
                    "set id_nhan_vien=?,id_khach_hang=?,id_dich_vu=?,ngay_lam_hop_dong=?,ngay_ket_thuc=?,tien_dat_coc=?,tong_tien=? where id_hop_dong=?");
            preparedStatement.setInt(1, contract.getEmployeeId());
            preparedStatement.setInt(2, contract.getCustomerId());
            preparedStatement.setInt(3, contract.getServiceId());
            preparedStatement.setString(4, contract.getContractStartDate());
            preparedStatement.setString(5, contract.getContractEndDate());
            preparedStatement.setDouble(6, contract.getContractDeposit());
            preparedStatement.setDouble(7, contract.getContractTotalMoney());
            preparedStatement.setInt(8, id);
            check = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
