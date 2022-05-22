<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<h3 class="page-title">
			Danh sách đơn hàng <small>Danh sách đơn hàng của bạn</small>
		</h3>

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
									<c:if test="${alert!=0}">
										<form method="post" action="order">
											<select name="cid" id="cid" onchange="this.form.submit()">
												<option value=""></option>
												<c:forEach items="${listcart}" var="o">
													<option value="${o.id}">${o.id}</option>
												</c:forEach>
											</select>
										</form>
									</c:if>
								</div>
								<div class="col-md-6"></div>
							</div>
						</div>
						<table class="table table-striped table-hover table-bordered"
							id="sample_editable_1">
							<thead>
								<tr>
									<th>Người nhận</th>
									<th>Tên sản phẩm</th>
									<th>Tên shop</th>
									<th>Danh mục</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Giảm giá(%)</th>
									<th>Phí vận chuyển</th>
									<th>Thành tiền</th>
									<th>Trạng thái</th>

								</tr>
							</thead>
							<tbody>
								<c:if test="${alert==2}">
									<c:forEach items="${listorder}" var="o">
										<c:if test="${o.bill.cart.id==idcart}">
											<tr>
												<td>Tên KH:${o.bill.fullname} <br> Địa
													chỉ:${o.bill.fulladdress} <br>
													SĐT:${o.bill.phonenumber} <br> Email:${o.bill.email} <br>
													Tỉnh thành:${o.bill.city.cityname}
												</td>
												<td>${o.product.productName}</td>
												<c:forEach items="${listseller}" var="s">
													<c:if test="${s.id==o.product.sellerId}">
														<td>${s.shopName}</td>
													</c:if>
												</c:forEach>
												<c:forEach items="${listcate}" var="c">
													<c:if test="${c.cateid==o.product.categoryId }">
														<td>${c.cname }</td>
													</c:if>
												</c:forEach>
												<td>${o.product.price}</td>
												<td>${o.cartitem.quantity}</td>
												<td>${o.product.discount}</td>
												<td>${o.bill.city.shipprice}</td>
												<td>${o.product.price*o.cartitem.quantity -o.product.price*o.product.discount/100*o.cartitem.quantity +o.bill.city.shipprice}</td>
												<c:if test="${o.cartitem.status==0 }">
													<td>Đang chờ xác nhận</td>
												</c:if>
												<c:if test="${o.cartitem.status==1 }">
													<td>Đã xác nhận</td>
												</c:if>
												<c:if test="${o.cartitem.status==-1 }">
													<td>Đã từ chối</td>
												</c:if>
											</tr>
										</c:if>
									</c:forEach>
								</c:if>
								<c:if test="${alert==0}">
									<span>Bạn chưa có giỏ hàng nào, mua hàng rồi quay trở
										lại nha</span>
								</c:if>
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