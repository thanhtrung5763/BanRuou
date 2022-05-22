<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

<c:if test="${alert==0}">
<script type="text/javascript">
			alert("Vui lòng đăng ký tài khoản");
			window.location = '/BanRuou/login'
		</script>
</c:if>


</body>
</html> 
