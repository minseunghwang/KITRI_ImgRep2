<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�̹��� �Խ���</h3>
<a href="${pageContext.request.contextPath }/imgBoard/imgWrite.jsp">�̹��� �ø���</a><br>
<c:forEach var="img" items="${products }">
<table border="1">
<tr><td>����</td><td>${img.title }</td></tr>
<tr><td>�Խ���</td><td>${img.writer }</td></tr>
<tr><td>�Խó�¥</td><td>${img.u_date }</td></tr>
<tr><td>�̹���</td>

<td>
<img src="${img.path }" width="300" height="300"></td></tr>
<tr><td colspan="2">
<form action="${pageContext.request.contextPath }/RepController?
img_num=${img.num}" method="post">
<input type="text" name="content">
<input type="submit" value="���">
</form>
</td></tr>
<c:forEach var="rep" items="${img.reps }">
<tr><td>�ۼ���:${rep.writer }</td><td>����:${rep.content }</td></tr>
</c:forEach>
</table>
</c:forEach>
</body>
</html>