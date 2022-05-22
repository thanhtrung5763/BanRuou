<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="wrap">
	<div class="container">
		<div class="row">
			<div class="col-md-6 d-flex align-items-center">
				<p class="mb-0 phone pl-md-2">
				<form method="post" action="/BanRuou/registerredirect">
					<c:if test="${sessionScope.acc ==null}">
						<input type="hidden" name="acc" value="null">
					</c:if>
					<c:if test="${sessionScope.acc !=null}">
						<input type="hidden" name="acc" value="${sessionScope.acc.uid}">
					</c:if>
					<button type="submit" class="mr-2">Kênh người bán</button>
				</form>
				</p>
			</div>
			<div class="col-md-6 d-flex justify-content-md-end">
				<div class="social-media mr-4">
					<p class="mb-0 d-flex">
						<a href="#"
							class="d-flex align-items-center justify-content-center"><span
							class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a> <a
							href="#" class="d-flex align-items-center justify-content-center"><span
							class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a> <a
							href="#" class="d-flex align-items-center justify-content-center"><span
							class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a> <a
							href="#" class="d-flex align-items-center justify-content-center"><span
							class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
					</p>
				</div>
				<div class="reg">
					<p class="mb-0">
						<c:choose>
							<c:when test="${sessionScope.acc ==null}">
								<a href="/BanRuou/login" class="mr-2">Đăng nhập</a>
							</c:when>
							<c:otherwise>
								<c:if test="${sessionScope.acc.isAdmin==1}">
									<a href="/BanRuou/admin/home" class="mr-2">${sessionScope.acc.username}</a>
								</c:if>
								<c:if test="${sessionScope.acc.isAdmin==0}">
									<a href="/BanRuou/home" class="mr-2">${sessionScope.acc.username}</a>
								</c:if>
								<a href="${pageContext.request.contextPath}/logout" class="mr-2">Đăng
									xuất</a>
							</c:otherwise>
						</c:choose>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>


<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="home">CLE <span>Liquor</span></a>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a href="/BanRuou/home"
					class="nav-link">Home</a></li>
				<li class="nav-item"><a href="/BanRuou/member/profile"
					class="nav-link">My account</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<c:forEach items="${listallcate}" var="q">
							<a class="dropdown-item" href="/BanRuou/product?cid=${q.cateid}">${q.cname}</a>
						</c:forEach>
					</div></li>
				<li class="nav-item"><a href="/BanRuou/product?cid=0"
					class="nav-link">Product</a></li>
				<li class="nav-item"><a href="/BanRuou/cart" class="nav-link">Cart</a></li>
			</ul>
		</div>
	</div>
</nav>
