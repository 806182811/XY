<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function (){
	quely();
})
function quely(){
$.ajax({
	async : false,//是否异步提交
	type : "post",//提交方式 get/post
	url : "goods?opt=quely",//请求到servlet的路径
	/*data : {"参数" : "值"},后台传值 */
	dataType : "json", //返回结果的类型xml, html, script, json, text, _default
	success : function(date)//成功时触发的函数
	{
		var trs = "<tr><th>产品编号</th><th> 产品名称</th><th>日期</th><th>地址</th><th>类型</th><th>价格</th><th colspan=\"2\">操作</th></tr>";
		$.each(date, function(i, v) {
			trs += "<td>" + v.number + "</td>";
			trs += "<td>" + v.name+ "</td>";
			trs += "<td>" + v.date+ "</td>";
			trs += "<td>" + v.address+ "</td>";
			trs += "<td>" + v.types+ "</td>";
			trs += "<td>" + v.prices+ "</td>";
			trs+="<td><a href=\"javascript:del("+ v.number +")\">删除</a></td>"
			trs += "</tr>";
		});
		$("#tbStus").html(trs);
	},
	error : function()//失败时触发的函数
	{
		//请求失败处理函数 
		alert("请求失败");
	}
});
}

function del(id){
	alert(id);
	$.ajax({
		async:false,
		type:"post",
		url:"goods?opt=del",
		data:{"id":id},
		datetype:"json",
		success:function(data){
			alert(data);
			if(data){
				quely();
			}else{
				alert("添加失败");
			}
		}
	});
}

</script>	
<body>
<table id="tbStus">

</table>
</body>
</html>