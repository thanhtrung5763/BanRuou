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
				<h2 class="mb-0 bread">Products</h2>
			</div>
		</div>
	</div>
</section>

<section class="ftco-section">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="row mb-4">
					<div
						class="col-md-12 d-flex justify-content-between align-items-center">
						<h4 class="product-select">Select Types of Products</h4>
						<div class="dropdown bootstrap-select show-tick">
							<form action="search" class="form-inline my-2 my-lg-0">
								<div class="input-group input-group-sm">
									<input type="text" name="txt" value="${txtS}"
										class="form-control" placeholder="Search...">
									<div class="input-group-append">
										<button type="submit" class="btn btn-secondary btn-number">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${listall}" var="p">
						<div class="col-md-4 d-flex">
							<div class="product ftco-animate">
								<c:url value="/image?fname=${p.imageLink}" var="imgUrl"></c:url>
								<div
									class="img d-flex align-items-center justify-content-center"
									style="background-image: url(<c:url value="/image?fname=${p.imageLink}"/>)">
									<div class="desc">
										<p class="meta-prod d-flex">
											<a
												href="<c:url value="cart-add?pId=${p.productId}&quantity=1"></c:url>"
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
										<c:if test="${o.cateid ==p.categoryId}">
											<span class="category">${o.cname}</span>
											<h2>${p.productName}</h2>
											<span class="price">$${p.price}</span>
											<span class="sold">Sold: ${p.sellAmount}</span>
										</c:if>
									</c:forEach>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
				<div class="row mt-5">
					<div class="col text-center">
						<div class="block-27">
							<ul>
								<c:if test="${tag>1}">
									<li><a class="page-link"
										href="product?cid=${cid}&index=${tag-1}">&laquo;</a></li>
								</c:if>
								<c:forEach begin="1" end="${endP}" var="i">
									<li class="page-item ${tag==i ? "active":""}"><a
										class="page-link" href="product?cid=${cid}&index=${i}">${i}</a></li>
								</c:forEach>
								<c:if test="${tag<endP}">
									<li class="page-item"><a class="page-link"
										href="product?cid=${cid}&index=${tag+1}">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="sidebar-box ftco-animate">
					<div class="categories">
						<h3>Product Types</h3>
						<ul class="p-0">
							<c:forEach items="${listallcate}" var="c">
								<li><a href="product?cid=${c.cateid}">${c.cname}<span
										class="fa fa-chevron-right"></span></a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<div class="sidebar-box ftco-animate">
					<c:forEach items="${top1pro}" var="p">
						<div class="product ftco-animate">
							<div class="img d-flex align-items-center justify-content-center"
								style="background-image: url(<c:url value="${p.imageLink}"/>);">
								<div class="desc">
									<p class="meta-prod d-flex">
										<a href="#"
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
									<c:if test="${p.categoryId == o.cateid}">
										<span class="seller">Best Seller</span>
										<span class="category">${p.categoryId}</span>
										<h2>${p.productName}</h2>
										<span class="price">$ ${p.price}</span>
										<span class="sold">Sold: ${p.sellAmount}</span>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>
</section>



