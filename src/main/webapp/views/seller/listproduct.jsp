<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<h3 class="page-title">
			Danh sách sản phẩm <small>Danh sách sản phẩm của bạn</small>
		</h3>

		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-edit"></i>Editable Table
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group"></div>
								</div>
								<div class="col-md-6">
									<div class="btn-group pull-right">
										<button class="btn dropdown-toggle" data-toggle="dropdown">
											Tools <i class="fa fa-angle-down"></i>
										</button>
										<ul class="dropdown-menu pull-right">
											<li><a href="#"> Print </a></li>
											<li><a href="#"> Save as PDF </a></li>
											<li><a href="#"> Export to Excel </a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">
							<thead>
								<tr>
									<th>Tên sản phẩm</th>
									<th>Mô tả</th>
									<th>Giá</th>
									<th>Hình ảnh</th>
									<th>Danh mục</th>
									<th>Số lượng trong kho</th>
									<th>Số lượng đã bán</th>
									<th>Giảm giá(%)</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listproduct}" var="o">
									<tr>
										<td>${o.productName }</td>
										<td>${o.description }</td>
										<td>${o.price}$</td>
										<c:url value="/image?fname=${o.imageLink}" var="imgUrl"></c:url>
										<td><img height="150" width="200" src="${imgUrl}" /></td>
										<c:forEach items="${listcate}" var="c">
											<c:if test="${c.cateid==o.categoryId }">
												<td>${c.cname }</td>
											</c:if>
										</c:forEach>
										<td>${o.inventory }</td>
										<td>${o.sellAmount }</td>
										<td>${o.discount}</td>
										<td><a class="edit" href="editproduct?pid=${o.productId}">
												Edit </a></td>
										<td><a class="delete"
											href="deleteproduct?pid=${o.productId}"> Delete </a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
		<!-- END PAGE CONTENT -->
	</div>
</div>
<!-- END CONTENT -->