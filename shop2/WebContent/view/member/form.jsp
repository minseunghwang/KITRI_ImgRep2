<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h3>ȸ������</h3>
		<form name="f" action="${pageContext.request.contextPath }/JoinController" method="post">
			<table border="1">
				<tr>
					<td>id</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>pwd</td>
					<td><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>address</td>
					<td><input type="text" name="addr"></td>
				</tr>			
				<tr>
					<td>ȸ������</td>
					<td>
						<input type="radio" name="type" value="1">�Ǹ���
						<input type="radio" name="type" value="2">������
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="����">
						<input type="reset" value="���">
					</td>
				</tr>
			</table>
		</form>

</html>