<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>membersJoin.jsp</title>
<script>

	// 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
	function checkValue() {
		if (!document.membersInfo.joinemail.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (!document.membersInfo.joinpw.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		if (document.membersInfo.joinpw.value != document.membersInfo.joinpwcheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
	<div id="wrap">
		<br>
		<br> <b><font size="6" color="gray">회원가입</font></b> <br>
		<br>
		<br>


		<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
		<!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 JoinPro.jsp -->
		<form method="post" action="${pageContext.request.contextPath}/membersJoin.do" name="membersInfo"
			onsubmit="return checkValue()">
			<table>
				<tr>
					<td id="title">이메일(아이디)</td>
					<td><input type="text" name="joinemail" maxlength="50"> <input
						type="button" value="중복확인"></td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="joinpw" maxlength="50">
					</td>
				</tr>

				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" name="joinpwcheck" maxlength="50">
					</td>
				</tr>

				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="joinname" maxlength="50"></td>
				</tr>

				<tr>
					<td id="title">성별</td>
					<td><input type="radio" name="joingender" value="남" checked>남
						<input type="radio" name="joingender" value="여" checked>여</td>
				</tr>

				<tr>
					<td id="title">생일</td>
					<td><input type="text" name="joinbirthyy" maxlength="4"
						placeholder="년(4자)" size="6"> <select name="joinbirthmm">
							<option value="">월</option>
							<option value="01">1</option>
							<option value="02">2</option>
							<option value="03">3</option>
							<option value="04">4</option>
							<option value="05">5</option>
							<option value="06">6</option>
							<option value="07">7</option>
							<option value="08">8</option>
							<option value="09">9</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
					</select> <input type="text" name="joinbirthdd" maxlength="2" placeholder="일"
						size="4"></td>
				</tr>

				<tr>
					<td id="title">휴대전화</td>
					<td><input type="text" name="joinphone" /></td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td><input type="text" size="50" name="joinaddr" /></td>
				</tr>
			</table>
			<br> <input type="submit" value="가입" />
				<input type="button" value="취소">
		</form>
	</div>
</body>
</html>