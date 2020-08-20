<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var arr = [];
var search = function(num){
	for(i=0;i<arr.length;i++){
		if(arr[i].num==num){
			return arr[i];
		}
	}
	return null;
}
var makeTbl = function(obj){
	var html = "<table border='1'>";
	html += "<tr><th>num</th><td>"+obj.num+"</td></tr>";
	html += "<tr><th>title</th><td>"+obj.title+"</td></tr>";
	html += "<tr><th>writer</th><td>"+obj.writer+"</td></tr>";
	html += "<tr><th>date</th><td>"+obj.u_date+"</td></tr>";
	html += "<tr><th>img</th><td><img src='"+obj.path+"' width=200 height=200></td></tr>";
	html += "</table>";
	$("#content").html(html);
}
$(document).ready(function(){	
	$.ajax({
        url: '${pageContext.request.contextPath }/ImgList',
        type: 'get',
        success: function(result){
        	arr = $.parseJSON(result);
        	var html = "<table border='1'>";
        	for(i=0;i<arr.length;i++){
        		html += "<tr><td class='title' num='"+arr[i].num+"'><h3 style='width:300px'>"+arr[i].title+"</h3></td></tr>";
        	}
        	html += "</table>"
        	$("#list").html(html);
        }
    });
	$(document).on('mouseover', '.title', function () {
        var num = $(this).attr("num");
        var obj = search(num);
        if(obj==null){
        	alert("not found");
        }else{
        	makeTbl(obj);
        }
	});
	$(document).on('mouseout', '.title', function () {
		$("#content").html("");
	});
});
</script>



</head>
<body>
<h3>이미지 타이틀에 마우스를 올려보세요</h3>
<table border="1">
<tr><td style="height:400px"><div id="list"></div></td>
<td style='width:300px'><div id="content"></div></td></tr>
</table>
</body>
</html>