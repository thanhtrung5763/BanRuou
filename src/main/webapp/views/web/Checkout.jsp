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
					<span class="mr-2"><a href="index.html">Home <i
							class="fa fa-chevron-right"></i></a></span> <span>Checkout <i
						class="fa fa-chevron-right"></i></span>
				</p>
				<h2 class="mb-0 bread">Checkout</h2>
			</div>
		</div>
	</div>
</section>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-10 ftco-animate">
				<form action="checkoutinfo" method="post" class="billing-form"
					id="billing">
					<h3 class="mb-4 billing-heading">Thông tin nhận hàng</h3>

					<div class="row align-items-end">
						<div class="col-md-12">
							<div class="form-group">
								<label for="firstname">Tên</label> <input type="text"
									class="form-control" name="fullname"
									placeholder="${account.fullname}" value="${account.fullname}"
									required>
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="fulladdress">Địa chỉ</label> <input type="text"
									class="form-control" name="fulladdress"
									placeholder="${account.diachi}" value="${account.diachi}"
									required>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label for="selectcity">Tỉnh</label>
								<div class="select-wrap">
									<div class="icon">
										<span class="ion-ios-arrow-down"></span>
									</div>
									<select name="selectcity" id="scity" class="form-control">
										<c:forEach items="${listcity}" var="o">
											<option value="${o.shipid}">${o.cityname}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="w-100"></div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="phone">Số điện thoại</label> <input type="text"
									class="form-control" name="phone" placeholder="${account.sdt}" value="${account.sdt}"
									required>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label for="email">Địa chỉ email</label> <input type="email"
									name="email" class="form-control" placeholder="" required>
							</div>
						</div>
						<div class="w-100"></div>
					</div>

					<div class="w-100"></div>
					<!-- END -->
					<p>
						<button type=submit class="btn btn-primary py-3 px-4" name="">Tiếp
							tục</button>
					</p>
				</form>
			</div>
			<!-- .col-md-8 -->
		</div>
	</div>
</section>
