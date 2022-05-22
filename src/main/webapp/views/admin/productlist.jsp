<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<!--Data Table-->
<script type="text/javascript"
	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>

<!--Export table buttons-->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js"></script>

<!--Export table button CSS-->

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<h3 class="page-title">
			Danh sách sản phẩm <small>Danh sách sản phẩm của bạn</small>
		</h3>
		<c:if test="${alert!=null}">
			<script>
			alert(${alert});
			</script>
		</c:if>
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
						<table id="tbl"
							class="table table-striped table-bordered table-condensed"
							style="width: 100%">
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
									<th>Mã ID Seller</th>
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
										<td>${o.sellerId}</td>
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
<script>
	$('#tbl').DataTable({
		dom : 'Bfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
</script>
<!-- END CONTENT -->