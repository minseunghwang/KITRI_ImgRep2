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
		var num = 10;
		$("#num").html(num);
		$("#keyTest").keyup(function(){
			var str = $(this).val();
			var l = num-str.length;
			
			if(l<=0){
				alert(num+"글자 초과 입력 불가");
				var s = str.substring(0,10);
				$(this).val(s);
			}
			$("#num").html(l);
			
		})
	})
</script>	
</head>
<body>
10글자까지만 입력 가능<br>
테스트 : <input type="text" id="keyTest">
<span id="num"></span>글자 입력 가능

</body>
</html>