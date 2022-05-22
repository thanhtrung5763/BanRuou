<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">
			<c:if test="${alert!=null}">
				<script>
					alert("Thêm sản phẩm thành công");
				</script>
			</c:if>
			Thêm sản phẩm <small>Đăng bán sản phẩm của bạn</small>
		</h3>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal form-row-seperated" method="post"
					action="addproduct" enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-md-2 control-label">Tên sản phẩm: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="name"
								placeholder="" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Mô tả: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<textarea class="form-control" name="description" required></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Danh mục: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<div class="form-control height-auto">
								<div class="scroller" style="height: 275px;"
									data-always-visible="1">

									<ul class="list-unstyled">
										<c:forEach items="${listcate}" var="o">
											<li><label><input type="radio" name="category"
													value="${o.cateid}">${o.cname}</label></li>
										</c:forEach>
									</ul>
								</div>

							</div>
							<span class="help-block"> Chọn một danh mục </span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Giá: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="price"
								placeholder="" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Số lượng trong kho:
							<span class="required"> * </span>
						</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="inventory"
								placeholder="" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Giảm giá: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="discount"
								placeholder="" required>
						</div>
					</div>
					<input type="hidden" name="sid" value="${sessionScope.sell.id}">
					<div class="form-group">
						<label class="col-md-2 control-label">Hình ảnh: <span
							class="required" required> * </span>
						</label> <input type="file" name="image" />
					</div>
					<button type="submit" class="btn btn-default">Thêm sản
						phẩm</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- END PAGE CONTENT-->
<!-- END CONTENT -->
