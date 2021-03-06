package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();

	public List<ItemInfoDTO> select(){
		 DBConnector db = new DBConnector();
		 Connection con = db.getConnection();

		String sql = "select * from item_info_transaction";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				ItemInfoDTO dto =new ItemInfoDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				itemInfoDTOList.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return itemInfoDTOList;
	}
}