<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- BEGIN STYLE CUSTOMIZER -->

		<!-- END STYLE CUSTOMIZER -->
		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">
			<c:if test="${alert!=null}">
				<script>
					alert("Thêm danh mục thành công");
				</script>
			</c:if>
			Thêm danh mục<small>  Danh mục hiển thị</small>
		</h3>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
			<c:url value="/admin/category/add" var="add"></c:url>
				<form class="form-horizontal form-row-seperated" method="post"
					action="${add}" enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-md-2 control-label">Tên danh mục: <span
							class="required"> * </span>
						</label>
						<div class="col-md-10">
							<input type="text" class="form-control" name="name"
								placeholder="" required>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">Hình ảnh: <span
							class="required" required> * </span>
						</label> <input type="file" name="imageLink" />
					</div>
					<button type="submit" class="btn btn-default">Thêm danh mục</button>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- END PAGE CONTENT-->
<!-- END CONTENT -->
