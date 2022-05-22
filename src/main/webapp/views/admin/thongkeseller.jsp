<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<!--Import jQuery before export.js-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.1.1.min.js"></script>


<!-- BEGIN CONTAINER -->

<br>
<br>
<br>
<br>

<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<div class="modal fade" id="portlet-config" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">Widget settings form goes here</div>
					<div class="modal-footer">
						<button type="button" class="btn blue">Save changes</button>
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- Begin: life time stats -->
				<div class="portlet">
					<c:url value="/BanRuou/admin/thongke" var="thongke"></c:url>
					<div class="col-md-7 col-xs-12">
						<form action="thongke" method="post">
							<div class="row">
								<div class="col-md-6 form-group">
									<input type="hidden" name="sellerid" value="${userid}" /> <input
										type="date" name="from_date" value="${date}"
										placeholder="Thoi gian bat dau..." class="form-control" />
								</div>
							</div>
							<input type="submit" value="Thong ke" class="btn btn-danger" />
						</form>
					</div>
				</div>
				<!-- End: life time stats -->
			</div>
		</div>
		<div class="chart-container"
			style="position: relative; height: 0vh; width: 50vw">
			<canvas id="myChart"></canvas>
		</div>
		<c:forEach items="${product}" var="item">
			<p
				style="text-align: left; -webkit-text-stroke: medium; margin-left: 900px;">${item.productId }
				: ${item.productName}</p>
		</c:forEach>


		<!-- END PAGE CONTENT-->
	</div>
</div>
<!-- END CONTENT -->

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<script>
	let labels = []
	let info = []

	<c:forEach items="${product}" var="item">
	labels.push('${item.productId}')
	</c:forEach>

	<c:forEach items="${product}" var="item">
	<c:set var="t" value="0"></c:set>
	<c:forEach items="${cartitem}" var="item1">
	<c:choose>
	<c:when test="${item.productName == item1.product.productName}">
	info.push('${item1.quantity}')
	<c:set var="t" value="1"></c:set>
	</c:when>
	</c:choose>
	</c:forEach>
	<c:if test="${t==0}">
	info.push('0')
	</c:if>

	</c:forEach>

	/* <c:forEach items="${cartitem}" var="item">
		info.push('${item.quantity}')
	</c:forEach> */

	var barColors = [ "red", "green", "blue", "orange", "brown" ];

	new Chart("myChart", {
		type : "bar",
		data : {
			labels : labels,
			datasets : [ {
				backgroundColor : barColors,
				data : info
			} ]
		},
		options : {
			legend : {
				display : false
			},
			title : {
				display : true,
				text : "Thống kê số lượng đã bán theo sản phẩm"
			},
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
</script>






