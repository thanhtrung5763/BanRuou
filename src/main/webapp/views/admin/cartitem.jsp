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
<div class="page-content-wrapper">
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEAD -->
			<div class="page-head">
				<!-- BEGIN PAGE TITLE -->
				<div class="page-title">
					<h1>
						Dashboard <small>statistics & reports</small>
					</h1>
				</div>
				<!-- END PAGE TITLE -->
				<!-- BEGIN PAGE TOOLBAR -->
				<div class="page-toolbar">
					<!-- BEGIN THEME PANEL -->
					<!-- END THEME PANEL -->
				</div>
				<!-- END PAGE TOOLBAR -->
			</div>
			<!-- END PAGE HEAD -->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb hide">
				<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
				<li class="active">Dashboard</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<div class="row">
				<div class="col-md-12">
					<!-- Begin: life time stats -->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>Cartitem
							</div>
						</div>
						<div class="portlet-body">
							<div class="table-container">
								<table id="tbl"
									class="table table-striped table-bordered table-condensed"
									style="width: 100%">
									<thead>
										<tr role="row" class="heading">
											<th width="10%">ID</th>
											<th width="15%">Tên sản phẩm</th>
											<th width="15%">Giá</th>
											<th width="15%">Số lượng</th>
									</thead>
									<tbody>
										<c:forEach items="${allcartitem}" var="cateitem"
											varStatus="STT">
											<tr class="odd gradeX">
												<td>${STT.index+1 }</td>
												<td>${cateitem.product.productName }</td>
												<td>$ ${cateitem.unitPrice}</td>
												<td>${cateitem.quantity }</td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<a href="${pageContext.request.contextPath}/admin/cart">Quay
							lại</a>
					</div>
					<!-- End: life time stats -->
				</div>
			</div>

			<!-- BEGIN PAGE CONTENT INNER -->

			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
</div>
<!-- END CONTENT -->
<script>
	$('#tbl').DataTable({
		dom : 'Bfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
</script>