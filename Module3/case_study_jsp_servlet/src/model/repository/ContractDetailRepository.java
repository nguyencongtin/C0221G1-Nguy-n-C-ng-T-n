package model.repository;

import model.bean.ContractDetail;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();
    public boolean addNewContractDetail(ContractDetail contractDetail) {
        Connection connection = baseRepository.connectDataBase();
        boolean check = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("{call create_contract_detail(?,?,?)}");
            callableStatement.setInt("p_id_hop_dong", contractDetail.getContractId());
            callableStatement.setInt("p_id_dich_vu_di_kem", contractDetail.getAttachServiceId());
            callableStatement.setInt("p_so_luong", contractDetail.getQuantity());
            check = callableStatement.executeUpdate() > 0;
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
