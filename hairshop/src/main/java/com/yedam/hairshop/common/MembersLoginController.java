package com.yedam.hairshop.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.hairshop.members.MembersDAO;
import com.yedam.hairshop.members.MembersVO;

public class MembersLoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("멤버로그인");

		// 파라미터 VO에 담기
		MembersVO membersVO = new MembersVO();
		membersVO.setMem_email(request.getParameter("mem_email"));
		membersVO.setMem_pw(request.getParameter("mem_pw"));

		// 2. 서비스 처리(DB)
		MembersVO resultVO = MembersDAO.getInstance().selectOne(membersVO); // memberVO 집어넣고 결과를 MemberVO로 받기

		// 3. 결과 저장
		String page = ""; // 이동할 페이지 이름 변수 선언
		if (resultVO == null) { // id가 없는 경우
			request.setAttribute("errormsg", "해당 ID가 없습니다.");
			page = "membersLogin.jsp";

		} else {
			if (membersVO.getMem_pw().equals(resultVO.getMem_pw())) { // memberVO에 있는 pw와 resultVO의 pw를 비교해서 같으면 로그인성공
				request.getSession().setAttribute("login", resultVO);
				request.getSession().setAttribute("id", resultVO.getMem_email());
				page = "../index.jsp";
			} else { // 패스워드 불일치
				request.setAttribute("errormsg", "패스워드 불일치");
				page = "membersLogin.jsp";
			}
		}

		// 4. 뷰페이지 이동(redirect, forward) 또는 뷰페이지 출력
		request.getRequestDispatcher(page).forward(request, response);

	}

}
