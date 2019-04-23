package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();


	public List<UserInfoDTO> select(){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from login_user_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				UserInfoDTO dto =new UserInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setInsert_date(rs.getString("insert_date"));
				userInfoDTOList.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTOList;
}




//	public int buyItemHistoryDelete
//	(String item_transaction_id,String user_master_id)throws SQLException{
//
//		String sql =
//				"DELETE FROM "
//					+ "login_user_transaction "
//				+ "WHERE"
//					+ " item_transaction_id = ? AND user_master_id = ?";
//		PreparedStatement preparedStatement;
//		int result = 0;
//		try{
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1,item_transaction_id);
//			preparedStatement.setString(2,user_master_id);
//
//			result = preparedStatement.executeUpdate();
//
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			connection.close();
//		}
//		return result;
//	}
}