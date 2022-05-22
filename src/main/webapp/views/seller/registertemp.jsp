<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<c:if test="${alert==1}">
		<script type="text/javascript">
			alert("Đăng ký trở thành người bán thành công");
			window.location = '/BanRuou/seller/home'
		</script>
	</c:if>
	<c:if test="${alert==0}">
		<script type="text/javascript">
			alert("Tên cửa hàng đã tồn tại");
			window.location = '/BanRuou/registerseller'
		</script>
	</c:if>

</body>
</html> 

