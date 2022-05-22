<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="hero-wrap hero-wrap-2"
	style="background-image: url(<c:url value='/templates/web/images/bg_2.jpg'/>);"
	data-stellar-background-ratio="0.5">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-end justify-content-center">
			<div class="col-md-9 ftco-animate mb-5 text-center">
				<p class="breadcrumbs mb-0">
					<span class="mr-2"><a href="index.html">Home <i
							class="fa fa-chevron-right"></i></a></span> <span>Products <i
						class="fa fa-chevron-right"></i></span>
				</p>
				<h2 class="mb-0 bread">CARTS</h2>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row">
			<div class="table-wrap">
				<table class="table">
					<thead class="thead-primary">
						<tr>
							<th>Image</th>
							<th>Product</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Discount</th>
							<th>total</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.cart}" var="map">
							<tr class="alert" role="alert">



								<td>
									<div class="img"
										style="background-image: url(<c:url value="/image?fname=${map.value.product.imageLink}"/>);"></div>
								</td>
								<td>
									<div class="email">${map.value.product.productName }</div>
								</td>
								<td>$ ${map.value.product.price}</td>
								<td class="quantity"><a
									href="${pageContext.request.contextPath}/cart-sub?pId=${map.value.product.productId}&quantity=1">
										<button class="btnSub">-</button>
								</a> <strong>${map.value.quantity}</strong> <a
									href="${pageContext.request.contextPath}/cart-add?pId=${map.value.product.productId}&quantity=1"><button
											class="btnAdd">+</button></a></td>
								<td>${map.value.product.discount}%</td>
								<td>$ ${map.value.product.price * map.value.quantity -map.value.product.discount/100 * map.value.product.price * map.value.quantity}</td>
								<td><a
									href="${pageContext.request.contextPath}/cart-remove?pId=${map.value.product.productId}"
									class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		<div class="row justify-content-end">
			<div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
				<div class="cart-total mb-3">

					<h3>Cart Totals</h3>
					<p class="d-flex">
						<span>Subtotal</span> <span></span>
					</p>
					<p class="d-flex">
						<span>Delivery</span> <span>$0.00</span>
					</p>
					<c:set var="total" value="${0}" />
					<c:forEach items="${sessionScope.cart}" var="map">
						<c:set var="total"
							value="${total + map.value.product.discount/100 * map.value.quantity*map.value.product.price}" />
					</c:forEach>
					<p class="d-flex">
						<span>Discount</span> <span>$ ${total}</span>
					</p>
					<hr>
					<c:set var="sum" value="${0}" />
					<c:forEach items="${sessionScope.cart}" var="map">
						<c:set var="sum"
							value="${sum + map.value.quantity * map.value.product.price - total}" />
					</c:forEach>
					<p class="d-flex total-price">
						<span>Total</span> <span>$ ${sum}</span>
					</p>
				</div>
				<div class="col mb-2">
					<div class="row">
						<div class="col-sm-12  col-md-6">

							<a href="<c:url value="/product?cid=0"></c:url>"
								class="btn btn-block btn-light btn-success text-uppercase">C.Shopping</a>

						</div>
						<div class="col-sm-12 col-md-6 text-right">
							<a href="<c:url value="/checkout"></c:url>"
								class="btn btn-lg btn-block btn-success text-uppercase">Checkout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<!-- loader -->
<div id="ftco-loader" class="show fullscreen">
	<svg class="circular" width="48px" height="48px">
		<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke="#eeeeee" />
		<circle class="path" cx="24" cy="24" r="22" fill="none"
			stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
</div>


