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
			alert("Đăng ký tài khoản thành công");
			window.location = '/BanRuou/login'
		</script>
	</c:if>
	<c:if test="${alert==0}">
		<script type="text/javascript">
			alert("Tên đăng nhập đã tồn tại");
			window.location = '/BanRuou/login'
		</script>
	</c:if>

</body>
</html>

