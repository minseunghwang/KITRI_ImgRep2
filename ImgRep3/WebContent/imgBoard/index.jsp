<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
var makeTbl = function(obj){
var html = "<table id='t_"+obj.num+"' border='1'>";
html += "<tr><th>num</th><td>"+obj.num+"</td></tr>";
html += "<tr><th>update</th><td><input type='button' value='edit'>";
html +=
"<input type='button' value='delete' num='"+obj.num+"' pwd='"+obj.pwd+"'>";

html += "</td></tr>";
html += "<tr><th>title</th><td>"+obj.title+"</td></tr>";
html += "<tr><th>writer</th><td>"+obj.writer+"</td></tr>";
html += "<tr><th>date</th><td>"+obj.u_date+"</td></tr>";
html += 
"<tr><th>img</th><td><img src='"+obj.path+"'width=200 height=200></td></tr>";
html += "</table>";
	$("#imglist").append(html);
}

var makeList = function(arr){
	for(i=0;i<arr.length;i++){
		makeTbl(arr[i]);
	}
}

$(document).ready(function(){
	$("#upload_form").hide();
	
	$.ajax({
        url: '${pageContext.request.contextPath }/ImgList',
        type: 'get',
        success: function(result){
        	var arr = $.parseJSON(result);
        	makeList(arr);
        }
    });
	
  	$("#addbtn").click(function(){
  		$("#title").val("");
  		$("#writer").val("");
  		$("#pwd").val("");
  		$("#file").val("");
    	$("#upload_form").show();
  	});
  	
  	$("#upload_btn").click(function(){
  		var form = $('#upload_form')[0];
        var formData = new FormData(form);

        $.ajax({
            url: '${pageContext.request.contextPath }/WriteController',
            data: formData,
            processData: false, //application/x-www-form-urlencoded Ÿ���� ��û�� ����ϴ� ������URL�� ���ڵ� �ȴ�. 
			contentType: false, //��û�� ��õǴ� ������ Ÿ��.
            type: 'POST',
            success: function(result){
            	var obj = $.parseJSON(result);
 				makeTbl(obj);
            }
        });
  		
    	$("#upload_form").hide();
  	});
  	
	$(document).on("click","input[value='delete']" ,function(){
		var pwd = prompt("�� ��й�ȣ");
		var pwd2 = $(this).attr("pwd");
		var num = $(this).attr("num");
	
		if(pwd==pwd2){
			$.ajax({
	    url: '${pageContext.request.contextPath }/DelController',
	            data: "num="+num,
	            type: 'POST',
	            success: function(result){
	            	var obj = $.parseJSON(result);
	            	if(obj.num==0){
	            		alert("������ ���� ó������ ������");
	            	}else{
	            		$("#t_"+obj.num).remove();
	            	}
	            }
	        });
		}else{
			alert("��й�ȣ ����ġ")
		}
	});
});
</script>
</head>
<body>
<h3>�̹��� �Խ���</h3>
<input type="button" id="addbtn" value="�̹��� �ø���"><br>
<form id="upload_form" method="post" enctype="multipart/form-data">
<table border="1">
<tr><td>����</td>
<td><input type="text" name="title" id="title"></td></tr>
<tr><td>�Խ���</td>
<td><input type="text" name="writer" id="writer"></td></tr>
<tr><td>�ۺ�й�ȣ</td>
<td><input type="password" name="pwd" id="pwd"></td></tr>
<tr><td>�̹���</td>
<td><input type="file" name="file" id="file"></td></tr>
<tr><td colspan="2"><input id="upload_btn" type="button" value="�ø���"></td></tr>
</table>
</form>
<div id="imglist"></div>

</body>
</html>