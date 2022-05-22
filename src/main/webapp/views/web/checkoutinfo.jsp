<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- END nav -->

<section class="hero-wrap hero-wrap-2"
	style="background-image: url('images/bg_2.jpg');"
	data-stellar-background-ratio="0.5">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-end justify-content-center">
			<div class="col-md-9 ftco-animate mb-5 text-center">
				<p class="breadcrumbs mb-0">
					<span class="mr-2"><a href="index.html">Checkout<i
							class="fa fa-chevron-right"></i></a></span> <span>Đơn hàng<i
						class="fa fa-chevron-right"></i></span>
				</p>
				<h2 class="mb-0 bread">Đơn hàng</h2>
			</div>
		</div>
	</div>
</section>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10 ftco-animate">
				<h3 class="mb-4 billing-heading">Đơn hàng của bạn</h3>
				<div class="w-100"></div>
				<div class="col-md-12">
					<div class="form-group">
						<label>Họ tên:${sessionScope.accdetail.fullname} </label> <br>
						<label>Số điện thoại:${sessionScope.accdetail.fullname} </label> <br>
						<label>Địa chỉ:${sessionScope.accdetail.diachi }</label> <br>
						<label>Email:${sessionScope.accdetail.imageLink }</label> <br>
						<label>Tỉnh thành:${sessionScope.city.cityname }</label>
					</div>
					<!-- END -->



					<div class="row mt-5 pt-3 d-flex">
						<form action="order" method="post" class="billing-form">
							<div class="col-md-12">
								<div class="cart-detail cart-total p-3 p-md-4">
									<h3 class="billing-heading mb-4">Cart Total</h3>
									<c:set var="cartsum" value="${0}" />
									<c:set var="cartdiscount" value="${0}" />
									<c:forEach items="${sessionScope.cart}" var="map">
										<c:set var="total" value="${0}" />
										<c:set var="total"
											value="${total + map.value.product.price * map.value.quantity}" />
										<c:if test="${map.value.product.discount!=0}">
											<c:set var="cartdiscount"
												value="${cartdiscount + total*discount }" />
										</c:if>
										<c:set var="cartsum" value="${cartsum+total}" />
									</c:forEach>
									<p class="d-flex">
										<span>Subtotal</span> <span>${cartsum}</span> <input
											type="hidden" name="subtotal" value="${cartsum}">
									</p>
									<c:if test="${city==null}">
										<p class="d-flex">
											<span>Delivery</span> <span>$0</span>
										</p>
										<c:set var="cartship" value="${0}" />
									</c:if>
									<c:if test="${city!=null}">
										<p class="d-flex">
											<span>Delivery</span> <span>$${city.shipprice}</span> <input
												type="hidden" name="shipprice" value="${city.shipprice}">
										</p>
										<c:set var="cartship" value="${city.shipprice}" />
									</c:if>
									<p class="d-flex">
										<span>Discount</span> <span>$${cartdiscount}</span>
									</p>
									<hr>
									<p class="d-flex total-price">
										<span>Total</span> <span>$
											${cartsum-cartdiscount+cartship}</span> <input type="hidden"
											name="total" value="${cartsum-cartdiscount+cartship}">
									</p>
								</div>
							</div>
							<div class="col-md-12">
								<div class="cart-detail p-3 p-md-4">
									<h3 class="billing-heading mb-4">Payment Method</h3>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
												<label><input type="radio" name="optradio" value="Chuyển khoản"
													class="mr-2"> Chuyển khoản</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
												<label><input type="radio" name="optradio" value="Trực tiếp"
													class="mr-2"> Trực tiếp</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
												<label><input type="radio" name="optradio" value="Paypal"
													class="mr-2"> Paypal</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-12">
											<div class="checkbox">
												<label><input type="checkbox" value="" class="mr-2">
													I have read and accept the terms and conditions</label>
											</div>
										</div>
									</div>
									<p>
										<button type="submit" class="btn btn-primary py-3 px-4">Place
											an order</button>
									</p>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- .col-md-8 -->
	</div>
</section>
