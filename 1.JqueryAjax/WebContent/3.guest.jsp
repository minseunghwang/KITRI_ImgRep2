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
			var name = $('.uname').val();
			var pwd = $('.passwd').val();
			var data = 'name=' + name+'&password='+pwd;
			alert(data);
			
			$.ajax({
				type : "POST",
				url : "/1.JqueryAjax/WelcomeServlet3",
				data : data,
				success : function(data){
					$('#message').html(data);
				}
			})
		})
	})
</script>
</head>
<body>

<form>
	<label>Enter your Name</label>
	<input type="text" name="uname" class="uname"><br>
	<label>Enter your Password</label>
	<input type="password" name="password" class="passwd"><br>
	<input type="button" id="b1" value="전송">
</form>
<div id="message"></div>

</body>
</html>