<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!--Import jQuery before export.js-->
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
	<div class="page-content">
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Data Tables</a> <i class="fa fa-angle-right"></i>
				</li>
				<li><a href="#">Editable Datatables</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
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
						<table id="tbl"
							class="table table-striped table-bordered table-condensed"
							style="width: 100%">


							<thead>
								<tr>
									<th>Username</th>
									<th>Là người bán</th>
									<th>Status</th>
									<th>Ban</th>
									<th>Delete</th>
									<th>Thông tin</th>
									<th>Thống kê</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listuser}" var="o">
									<tr>
										<td>${o.username}</td>
										<c:if test="${o.isSeller == 1}">
											<td>YES</td>
										</c:if>
										<c:if test="${o.isSeller == 0}">
											<td>NO</td>
										</c:if>
										<td>${o.status}</td>
										<c:if test="${o.status  == 0 && o.isAdmin == 0}">
											<td><a class="edit" href="account/ban?uid=${o.uid}">
													Ban </a></td>
										</c:if>
										<c:if test="${o.status  == 0 && o.isAdmin == 1}">
											<td><a class="edit" href="account/ban?uid=${o.uid}">
											</a></td>
										</c:if>
										<c:if test="${o.status == 1 && o.isAdmin == 0 }">
											<td><a class="edit" href="account/unban?uid=${o.uid}">
													Unban </a></td>
										</c:if>
										<c:if test="${o.status == 1 && o.isAdmin == 1 }">
											<td><a class="edit" href="account/unban?uid=${o.uid}">
											</a></td>
										</c:if>
										<c:if test="${o.isAdmin == 1 }">
											<td><a class="delete" href="account/delete?uid=${o.uid}">
													</a></td>
										</c:if>
										<c:if test="${o.isAdmin == 0 }">
											<td><a class="delete" href="account/delete?uid=${o.uid}">
													Delete </a></td>
										</c:if>
										<td><a class="delete"
											href="account/memberprofile?uid=${o.uid}"> Info </a></td>
										<c:if test="${o.isSeller ==1}">
											<td><a class="edit"
												href="/BanRuou/admin/thongke?userid=${o.uid}&date=${date}">
													Thống kê </a></td>
										</c:if>
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


<script>
	$('#tbl').DataTable({
		dom : 'Bfrtip',
		buttons : [ 'copy', 'csv', 'excel', 'pdf', 'print' ]
	});
</script>