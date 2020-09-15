package com.yedam.hairshop.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public MembersVO selectOne(MembersVO memberVO) {
		MembersVO member = null; // select할때는 리턴값이 필요해서 리턴값을 저장할 변수 선언

		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from member" + " where id=?"; // 컨+쉬+x 대문자, 컨+쉬+y 소문자 변환가능. 쿼리 엔터해서 쓸거면 앞에 공백 붙이기
			pstmt = conn.prepareStatement(sql); // 미리 sql 구문이 준비가 되어야한다
			pstmt.setString(1, memberVO.getId()); // ?의 첫번째 자리에 올 값 지정
			rs = pstmt.executeQuery(); // select 시에는 executeQuery() 쓰기

			if (rs.next()) { // 단건조회라서 next()로 한건 한건마다 true 인지 false인지 확인하고 이동함
				member = new MembersVO();
				member.setId(rs.getString(1)); // 컬럼이 첫번째 자리라서 1을 입력한거임
				member.setPw(rs.getString("pw"));
				member.setGender(rs.getString("gender")); // 컬럼명에다가 별칭있으면 별칭을 넣어줘야함
				member.setJob(rs.getString("job")); // 대소문자 구별 없음
			} else {
				System.out.println("no data");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(rs, pstmt, conn);
		}
		return member; // 값을 리턴해줌
	}

}
