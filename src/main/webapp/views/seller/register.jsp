<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="portlet box purple ">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i> Đăng ký trở thành người bán của shop rượu CLE
							</div>
							
						</div>
						<div class="portlet-body form">
							<form class="form-horizontal" role="form" method="post" action="registerseller">
								<div class="form-body">
								<input type="hidden" id="userId" name="userId" value="${sessionScope.acc.uid}">
									<div class="form-group">
										<label class="col-md-3 control-label">Tên Shop</label>
										<div class="col-md-9">
											<input type="text" name="shopname" class="form-control input-lg" placeholder="Tên shop" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Tỉnh</label>
										<div class="col-md-9">
											<input type="text" name="province" class="form-control" placeholder="Tỉnh" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Huyện</label>
										<div class="col-md-9">
											<input type="text" name="district" class="form-control input-sm" placeholder="Huyện" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Địa chỉ</label>
										<div class="col-md-9">
											<input type="text" name="fulladdress" class="form-control input-sm" placeholder="Địa chỉ" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Số điện thoại</label>
										<div class="col-md-9">
											<input type="text" name="phone" class="form-control input-sm" placeholder="Số điện thoại" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-md-3 control-label">Email</label>
										<div class="col-md-9">
											<input type="text" name="email" class="form-control input-sm" placeholder="Email" required>
										</div>
									</div>
								<div class="form-actions right1">
									<button type="button" class="btn default">Hủy bỏ</button>
									<button type="submit" class="btn green">Lưu</button>
								</div>
								</div>
							</form>
						</div>
					</div>