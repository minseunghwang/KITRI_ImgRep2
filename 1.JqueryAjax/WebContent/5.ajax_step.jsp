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
		$('.id').change(function(){
			var name = $('.id').val();
			var data = 'id=' + name;
			alert(data);
			
			$.ajax({
				type : "POST",	
				url : "/1.JqueryAjax/WelcomeServlet5",
				data : data,
				success : function(data){
					$('div').append(data);
				}
			})
		})
	})
</script>
</head>
<body>
	이름 : <input type="text" class="id">
	<!-- span과 동일하다 단지 행만 바뀜 -->
	<div></div>
</body>
</html>