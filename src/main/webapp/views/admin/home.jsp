<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
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
		<h3 class="page-title">
			Dashboard <small>reports & statistics</small>
		</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Dashboard</a></li>
			</ul>

		</div>
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="dashboard-stat blue-madison">
					<div class="visual">
						<i class="fa fa-comments"></i>
					</div>
					<div class="details">
						<div class="number">${tongsanpham}</div>
						<div class="desc">Sản phẩm</div>
					</div>
					<a class="more" href="/BanRuou/admin/product"> Xem thêm <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="dashboard-stat red-intense">
					<div class="visual">
						<i class="fa fa-bar-chart-o"></i>
					</div>
					<div class="details">
						<div class="number">${tongdanhmuc}</div>
						<div class="desc">Danh mục</div>
					</div>
					<a class="more" href="/BanRuou/admin/category"> Xem thêm <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="dashboard-stat green-haze">
					<div class="visual">
						<i class="fa fa-shopping-cart"></i>
					</div>
					<div class="details">
						<div class="number">549</div>
						<div class="desc">Đã bán</div>
					</div>
					<a class="more" href="#"> Xem thêm<i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
				<div class="dashboard-stat purple-plum">
					<div class="visual">
						<i class="fa fa-globe"></i>
					</div>
					<div class="details">
						<div class="number">${tongaccount}</div>
						<div class="desc">Tài khoản</div>
					</div>
					<a class="more" href="/BanRuou/admin/account"> Xem thêm <i
						class="m-icon-swapright m-icon-white"></i>
					</a>
				</div>
			</div>
		</div>
		<!-- END DASHBOARD STATS -->
		<div class="clearfix"></div>


	</div>
</div>


