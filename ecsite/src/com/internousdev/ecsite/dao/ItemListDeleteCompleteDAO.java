package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public int deleteItemList() throws SQLException {
		String sql = "DELETE FROM item_info_transaction";
		PreparedStatement preparedStatement;
		int result =0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

}
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.internousdev.ecsite.dto.ItemInfoDTO;
//import com.internousdev.ecsite.util.DBConnector;
//
//public class ItemListDeleteCompleteDAO {
//
//	List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();
//
//	public int buyItemListDelete() throws SQLException{
//
//		DBConnector db = new DBConnector();
//		Connection con = db.getConnection();
//
//		String sql ="delete * from item_info_transaction";
//
//		PreparedStatement preparedStatement = null;
//		int result = 0;
//		try{
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//
//			result = preparedStatement.executeUpdate();
//
//		}catch(SQLException e){
//			e.printStackTrace();
//		}try {
//			con.close();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//}