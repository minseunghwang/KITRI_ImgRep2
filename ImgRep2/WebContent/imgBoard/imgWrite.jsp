<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�̹��� �ø���</h3>
<form action="${pageContext.request.contextPath }/WriteController"  
method="post" enctype="multipart/form-data">
<table border="1">
<tr><td>����</td>
<td><input type="text" name="title"></td></tr>
<tr><td>�Խ���</td>
<td><input type="text" name="writer"></td></tr>
<tr><td>�̹���</td>
<td><input type="file" name="file"></td></tr>
<tr><td colspan="2"><input type="submit" value="�ø���"></td></tr>
</table>
</form>
</body>
</html>