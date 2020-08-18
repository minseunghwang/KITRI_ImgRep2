<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn1").click(function(){
			var id = $("#id").val();
			var data = "id=" + id;
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/IdCheckController",
				data : data,
				success : function(data){
					var result = $.parseJSON(data);
					var str = "중복된 아이디";
					if(result.flag){
						str = "사용 가능한 아이디";
					}
					$("#res").html(str);
				}
			})
		})
	})
	
</script>
</head>
<body>

	<form action ="<%=request.getContextPath() %>/RegisterController">
		아이디 : <input type="text" name="id" id="id">
		<input type="button" value="중복체크" id="btn1">
		<span id="res"></span><br>
		패스워드 : <input type="password" name="password"><br>
		이름 : <input type="text" name="name"><br>
		주소 : <input type="text" name="address"><br>
		<input type="submit" value="회원가입"> 
	</form>

</body>
</html>