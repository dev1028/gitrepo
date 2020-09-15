package com.yedam.hairshop.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.yedam.hairshop.common.ConnectionManager;

public class MembersDAO {

	// 전역변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs = null;

	// 싱글톤
	static MembersDAO instance;

	public static MembersDAO getInstance() {
		if (instance == null)
			instance = new MembersDAO();
		return instance;
	}

	// 단건 조회
	public MembersVO selectOne(MembersVO membersVO) {
		MembersVO members = null; // select할때는 리턴값이 필요해서 리턴값을 저장할 변수 선언

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from members " + " where mem_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, membersVO.getMem_no());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				members = new MembersVO();
				members.setMem_no(rs.getString(1));
				members.setMem_email(rs.getString(2));
				members.setMem_pw(rs.getString(3));
				members.setMem_name(rs.getString(4));
				members.setMem_phone(rs.getString(5));
				members.setMem_birth(rs.getString(6));
				members.setMem_sex(rs.getString(7));
				members.setMem_addr(rs.getString(8));
				members.setMem_city(rs.getString(9));
				members.setMem_country(rs.getString(10));
				members.setMem_township(rs.getString(11));
				members.setMem_latitude_longitude(rs.getString(12));
				members.setMem_country(rs.getString(13));
				members.setMem_country(rs.getString(14));
				members.setMem_country(rs.getString(15));
				members.setMem_country(rs.getString(16));
			} else {
				System.out.println("no data");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return members; // 값을 리턴해줌
	}

}
