<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<title>CLE Liquor Store</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="<c:url value="/templates/web//css/animate.css"/>">

<link rel="stylesheet"
	href="<c:url value="/templates/web/css/owl.carousel.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/web/css/magnific-popup.css"/>">

<link rel="stylesheet"
	href="<c:url value="/templates/web/css/flaticon.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/web/css/style.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/css/owl.theme.default.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/templates/css/magnific-popup.css"/>">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">


</head>

<body>

	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!--  end header -->
	<!-- container -->

	<dec:body />

	<!-- end container -->
	<!--  footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- end footer -->
	<!-- JS -->
	<script src="<c:url value="/templates/web/js/jquery.min.js"/>"></script>
	<script
		src="<c:url value="/templates/web/js/jquery-migrate-3.0.1.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/popper.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/jquery.easing.1.3.js"/>"></script>
	<script
		src="<c:url value="/templates/web/js/jquery.waypoints.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/jquery.stellar.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/owl.carousel.min.js"/>"></script>
	<script
		src="<c:url value="/templates/web/js/jquery.magnific-popup.min.js"/>"></script>
	<script
		src="<c:url value="/templates/web/js/jquery.animateNumber.min.js"/>"></script>
	<script src="<c:url value="/templates/web/js/scrollax.min.js"/>"></script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="<c:url value="/templates/web/js/google-map.js"/>"></script>
	<script src="<c:url value="/templates/web/js/main.js"/>"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script src="js/google-map.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>	
	<script src="js/main.js"></script>

	<script>
		$(document).ready(function() {

			var quantitiy = 0;
			$('.quantity-right-plus').click(function(e) {

				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				$('#quantity').val(quantity + 1);

				// Increment

			});

			$('.quantity-left-minus').click(function(e) {
				// Stop acting like a button
				e.preventDefault();
				// Get the field name
				var quantity = parseInt($('#quantity').val());

				// If is not undefined

				// Increment
				if (quantity > 0) {
					$('#quantity').val(quantity - 1);
				}
			});

		});
	</script>
</body>
</html>