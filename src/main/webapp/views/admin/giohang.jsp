<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="/templates/assets" var="url"></c:url>

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
							<i class="fa fa-gift"></i>Cart
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
										<th width="15%">Tài khoản</th>
										<th width="15%">Họ tên</th>
										<th width="15%">Tổng tiền giỏ hàng</th>
										<th width="15%">Ngày mua</th>
								</thead>
								<tbody>
									<c:forEach items="${allcart}" var="cart">
										<tr class="odd gradeX">
											<td><a
												href="${pageContext.request.contextPath}/admin/cartitem?cartid=${cart.id}"
												id=""> ${cart.id } </a></td>
											<td>${cart.buyer.username}</td>
											<c:forEach items="${accountdetail}" var="account">
												<c:if test="${account.uid == cart.buyer.uid}">
													<td>${account.fullname}</td>
												</c:if>
											</c:forEach>
											<td>${cart.total}</td>
											<td>${cart.buyDate }</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- End: life time stats -->
			</div>
		</div>

		<!-- BEGIN PAGE CONTENT INNER -->

		<!-- END PAGE CONTENT INNER -->
	</div>
</div>
<script>
	$('#tbl').DataTable({
		dom : 'Bfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
</script>
