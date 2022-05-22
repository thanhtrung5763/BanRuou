<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<h3 class="page-title">
			Danh sách đơn hàng <small>Danh sách đơn hàng của bạn</small>
		</h3>
	<form action="order/accept" method="post">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-edit"></i>Danh sách đơn hàng
						</div>
						
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group"></div>
								</div>
								<div class="col-md-6">									
								</div>
							</div>
						</div>
						
						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">
							<thead>
								<tr>
									<th>Thông tin khách hàng</th>
									<th>Tên sản phẩm</th>								
									<th>Danh mục</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Giảm giá(%)</th>
									<th>Phí vận chuyển</th>
									<th>Thành tiền</th>
									<th></th>
									<th></th>
								</tr>
							</thead>

							<tbody>
							
								<c:forEach items="${listorder}" var="o">
									<tr>
										<td>Tên KH:${o.bill.fullname} <br>
											Địa chỉ:${o.bill.fulladdress} <br>
											SĐT:${o.bill.phonenumber} <br>
											Email:${o.bill.email} <br>
											Tỉnh thành:${o.bill.city.cityname}
										</td>
										<td>${o.product.productName}</td>
										<c:forEach items="${listcate}" var="c">
											<c:if test="${c.cateid==o.product.categoryId }">
												<td>${c.cname }</td>
											</c:if>
										</c:forEach>
										<td>${o.product.price}</td>
										<td>${o.cartitem.quantity}</td>
										<td>${o.product.discount}</td>
										<td>${o.bill.city.shipprice}</td>
										<td>${o.product.price*o.cartitem.quantity -o.product.price*o.product.discount/100 +o.bill.city.shipprice}</td>
										<c:if test="${ o.cartitem.status==0}">
										<td><a class="accept" href="order/accept?ciid=${o.cartitem.id }&caid=${o.cartitem.cartid.id}">
												Chấp nhận </a></td>
										<td><a class="delete"
											href="order/deny?ciid=${o.cartitem.id}&caid=${o.cartitem.cartid.id}"> Từ chối </a></td>
										</c:if>
										<c:if test="${ o.cartitem.status==1}">
										<td><a class="accept" href="#">
												Đã chấp nhận </a></td>
										<td><a class="delete"
											href="#">  </a></td>
										</c:if>		
										<c:if test="${o.cartitem.status==-1}">
										<td><a class="accept" href="#">
												 </a></td>
										<td><a class="delete"
											href="#"> Đã từ chối  </a></td>
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
		</form>
	</div>
</div>
<!-- END CONTENT -->