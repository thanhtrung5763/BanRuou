<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="hero-wrap"
	style="background-image: url(<c:url value='/templates/web/images/bg_2.jpg'/>)"
	data-stellar-background-ratio="0.5">
	<div class="overlay"></div>
	<div class="container">
		<div
			class="row no-gutters slider-text align-items-center justify-content-center">
			<div class="col-md-8 ftco-animate d-flex align-items-end">
				<div class="text w-100 text-center">
					<h1 class="mb-4">
						Good <span>Drink</span> for Good <span>Moments</span>.
					</h1>
					<p>
						<a href="product?cid=0" class="btn btn-primary py-2 px-4">Shop
							Now</a> <a href="#" class="btn btn-white btn-outline-white py-2 px-4">Read
							more</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<section class="ftco-intro">
	<div class="container">
		<div class="row no-gutters">
			<div class="col-md-4 d-flex">
				<div class="intro d-lg-flex w-100 ftco-animate">
					<div class="icon">
						<span class="flaticon-support"></span>
					</div>
					<div class="text">
						<h2>Online Support 24/7</h2>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 d-flex">
				<div class="intro color-1 d-lg-flex w-100 ftco-animate">
					<div class="icon">
						<span class="flaticon-cashback"></span>
					</div>
					<div class="text">
						<h2>Money Back Guarantee</h2>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 d-flex">
				<div class="intro color-2 d-lg-flex w-100 ftco-animate">
					<div class="icon">
						<span class="flaticon-free-delivery"></span>
					</div>
					<div class="text">
						<h2>Free Shipping &amp; Return</h2>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section ftco-no-pb">
	<div class="container">
		<div class="row">
			<c:forEach items="${listtop1}" var="o">
				<div
					class="col-md-6 img img-3 d-flex justify-content-center align-items-center"
					style="background-image: url(<c:url value="/image?fname=${o.imageLink}"/>); background-size: 70% 100%;
        background-repeat: no-repeat;
        border: 1px solid #999;">
				</div>
				<div class="col-md-6 wrap-about pl-md-5 ftco-animate py-5">
					<div class="heading-section">
						<span class="subheading">TOP OF PRODUCT</span>
						<h2 class="mb-4">${o.productName}</h2>
						<p>${o.description}</p>
						<p class="year">
							<span>Price:</span> <strong class="number"
								data-number="${o.price}">0</strong> <span>$</span>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>


<section class="ftco-section ftco-no-pb">
	<div class="container">
		<div class="row">
			<c:forEach items="${list6cate}" var="a">
				<div class="col-lg-2 col-md-4 ">
					<div class="sort w-100 text-center ftco-animate">
						<div class="img"
							style="background-image: url(<c:url value="/image?fname=${a.icons}"/>)"></div>
						<h3>${a.cname}</h3>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center pb-5">
			<div class="col-md-7 heading-section text-center ftco-animate">
				<span class="subheading">Our Delightful offerings</span>
				<h2>Tastefully Yours</h2>
			</div>
		</div>
		<div class="row">
			<c:forEach items="${list8}" var="p">
				<div class="col-md-3 d-flex">
					<div class="product ftco-animate">
						<div class="img d-flex align-items-center justify-content-center"
							style="background-image: url(<c:url value="/image?fname=${p.imageLink}"/>)">
							<div class="desc">
								<p class="meta-prod d-flex">
									<a href="cart-add?pId=${p.productId}&quantity=1"
										class="d-flex align-items-center justify-content-center"><span
										class="flaticon-shopping-bag"></span></a> <a href="#"
										class="d-flex align-items-center justify-content-center"><span
										class="flaticon-heart"></span></a> <a
										href="productdetail?cid=${p.categoryId}&pid=${p.productId}"
										class="d-flex align-items-center justify-content-center"><span
										class="flaticon-visibility"></span></a>
								</p>
							</div>
						</div>
						<div class="text text-center">
							<c:forEach items="${listallcate}" var="o">

								<span class="sale">NEW</span>
								<c:if test="${o.cateid ==p.categoryId}">
									<span class="category">${o.cname}</span>
									<h2>${p.productName}</h2>
									<p class="mb-0">
										<span class="price price-sale">$${p.price}</span> <span
											class="price">$49.00</span>
									</p>
								</c:if>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
		<div class="row justify-content-center">
			<div class="col-md-4">
				<a href="product?cid=0" class="btn btn-primary d-block">View All
					Products <span class="fa fa-long-arrow-right"></span>
				</a>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section testimony-section img"
	style="background-image: url(images/bg_4.jpg);">
	<div class="overlay"></div>
	<div class="container">
		<div class="row justify-content-center mb-5">
			<div
				class="col-md-7 text-center heading-section heading-section-white ftco-animate">
				<span class="subheading">Chứng nhận</span>
				<h2 class="mb-3">Hệ thống chuyên nghiệp</h2>
			</div>
		</div>
		<div class="row ftco-animate">
			<div class="col-md-12">
				<div class="carousel-testimony owl-carousel ftco-owl">
					<div class="item">
						<div class="testimony-wrap py-4">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-quote-left">
							</div>
							<div class="text">
								<p class="mb-4">Gặp thằng nào, tao ban thằng đó</p>
								<div class="d-flex align-items-center">
									<div class="user-img"
										style="background-image: url(<c:url value="/image?fname=user/person_1.jpg"/>)"></div>
									<div class="pl-3">
										<p class="name">Võ Văn Song Toàn</p>
										<span class="position">Chủ tịch hội đồng quản trị</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="testimony-wrap py-4">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-quote-left">
							</div>
							<div class="text">
								<p class="mb-4">
									Mẹ anh dặn anh đủ thứ<br> Nhưng quên dặn đừng say em.
								</p>
								<div class="d-flex align-items-center">
									<div class="user-img"
										style="background-image: url(<c:url value="/image?fname=user/person_2.jpg"/>)"></div>
									<div class="pl-3">
										<p class="name">Trần Ân</p>
										<span class="position">Thử rượu</span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="item">
						<div class="testimony-wrap py-4">
							<div
								class="icon d-flex align-items-center justify-content-center">
								<span class="fa fa-quote-left">
							</div>
							<div class="text">
								<p class="mb-4">
									Mẹ anh dặn anh đủ thứ<br> Và bả dặn đừng quen em.
								</p>
								<div class="d-flex align-items-center">
									<div class="user-img"
										style="background-image: url(<c:url value="/image?fname=user/person_3.jpg"/>)"></div>
									<div class="pl-3">
										<p class="name">Huỳnh Lý Bằng</p>
										<span class="position">Pha chế rượu</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>



<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center mb-5">
			<div class="col-md-7 heading-section text-center ftco-animate">
				<span class="subheading">Blog</span>
				<h2>Recent Blog</h2>
			</div>
		</div>
		<div class="row d-flex">
			<div class="col-lg-6 d-flex align-items-stretch ftco-animate">
				<div class="blog-entry d-flex">
					<a href="blog-single.html" class="block-20 img"
						style="background-image: url('images/image_1.jpg');"> </a>
					<div class="text p-4 bg-light">
						<div class="meta">
							<p>
								<span class="fa fa-calendar"></span> 23 April 2020
							</p>
						</div>
						<h3 class="heading mb-3">
							<a href="#">The Recipe from a Winemaker’s Restaurent</a>
						</h3>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
						<a href="#" class="btn-custom">Continue <span
							class="fa fa-long-arrow-right"></span></a>

					</div>
				</div>
			</div>
			<div class="col-lg-6 d-flex align-items-stretch ftco-animate">
				<div class="blog-entry d-flex">
					<a href="blog-single.html" class="block-20 img"
						style="background-image: url('images/image_2.jpg');"> </a>
					<div class="text p-4 bg-light">
						<div class="meta">
							<p>
								<span class="fa fa-calendar"></span> 23 April 2020
							</p>
						</div>
						<h3 class="heading mb-3">
							<a href="#">The Recipe from a Winemaker’s Restaurent</a>
						</h3>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
						<a href="#" class="btn-custom">Continue <span
							class="fa fa-long-arrow-right"></span></a>

					</div>
				</div>
			</div>
			<div class="col-lg-6 d-flex align-items-stretch ftco-animate">
				<div class="blog-entry d-flex">
					<a href="blog-single.html" class="block-20 img"
						style="background-image: url('images/image_3.jpg');"> </a>
					<div class="text p-4 bg-light">
						<div class="meta">
							<p>
								<span class="fa fa-calendar"></span> 23 April 2020
							</p>
						</div>
						<h3 class="heading mb-3">
							<a href="#">The Recipe from a Winemaker’s Restaurent</a>
						</h3>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
						<a href="#" class="btn-custom">Continue <span
							class="fa fa-long-arrow-right"></span></a>

					</div>
				</div>
			</div>
			<div class="col-lg-6 d-flex align-items-stretch ftco-animate">
				<div class="blog-entry d-flex">
					<a href="blog-single.html" class="block-20 img"
						style="background-image: url('images/image_4.jpg');"> </a>
					<div class="text p-4 bg-light">
						<div class="meta">
							<p>
								<span class="fa fa-calendar"></span> 23 April 2020
							</p>
						</div>
						<h3 class="heading mb-3">
							<a href="#">The Recipe from a Winemaker’s Restaurent</a>
						</h3>
						<p>A small river named Duden flows by their place and supplies
							it with the necessary regelialia.</p>
						<a href="#" class="btn-custom">Continue <span
							class="fa fa-long-arrow-right"></span></a>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
