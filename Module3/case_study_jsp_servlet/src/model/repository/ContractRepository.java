package model.repository;

import model.bean.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();

    public boolean addNewContract(Contract contract) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call create_contract(?,?,?,?,?,?,?)}");
            callableStatement.setInt("p_id_nhan_vien", contract.getEmployeeId());
            callableStatement.setInt("p_id_khach_hang", contract.getCustomerId());
            callableStatement.setInt("p_id_dich_vu", contract.getServiceId());
            callableStatement.setString("p_ngay_lam_hop_dong", contract.getContractStartDate());
            callableStatement.setString("p_ngay_ket_thuc", contract.getContractEndDate());
            callableStatement.setDouble("p_tien_dat_coc", contract.getContractDeposit());
            callableStatement.setDouble("p_tong_tien", contract.getContractTotalMoney());

            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Contract> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Contract> contractList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select* from hop_dong");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int contractId = resultSet.getInt("id_hop_dong");
                int employeeId = resultSet.getInt("id_nhan_vien");
                int customerId = resultSet.getInt("id_khach_hang");
                int serviceId = resultSet.getInt("id_dich_vu");
                String contractStartDate = resultSet.getString("ngay_lam_hop_dong");
                String contractEndDate = resultSet.getString("ngay_ket_thuc");
                double contractDeposit = resultSet.getDouble("tien_dat_coc");
                double contractTotalMoney = resultSet.getDouble("tong_tien");
                Contract contract = new Contract(contractId,employeeId,customerId,serviceId,contractStartDate,contractEndDate,contractDeposit,contractTotalMoney);
                contractList.add(contract);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}