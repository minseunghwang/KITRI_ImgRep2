<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${sessionScope.id }�� �α��� ����<br>
<a href="${pageContext.request.contextPath }/SearchController">����������</a><br>
<a href="${pageContext.request.contextPath }/LogoutController">�α׾ƿ�</a><br>
<a href="${pageContext.request.contextPath }/DelController">Ż��</a><br>
<a href="${pageContext.request.contextPath }/seller/list">���θ�</a><br>
</body>
</html>