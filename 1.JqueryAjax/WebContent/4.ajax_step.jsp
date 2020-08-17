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
		$('#b1').click(function(){
			var name = $('.userName').val();
			var data = 'name=' + name;
			alert(data);
			
			$.ajax({
				type : "POST",
				url : "/1.JqueryAjax/WelcomeServlet4",
				data : data,
				success : function(data){
					$('span').append(data);
				}
			})
		})
	})
</script>
</head>
<body>
	이름 : <input type="text" class="userName">
	<input type="button" id="b1" value="별명조회">
	<span></span>
</body>
</html>