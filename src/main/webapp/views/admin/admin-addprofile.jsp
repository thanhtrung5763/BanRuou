<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="page-content-wrapper">
	<div class="page-content">

		<!-- BEGIN PAGE CONTENT-->
		<div class="row margin-top-20">
			<div class="col-md-12">
				<!-- BEGIN PROFILE SIDEBAR -->
				<div class="profile-sidebar">
					<!-- PORTLET MAIN -->
					<div class="portlet light profile-sidebar-portlet">
						<!-- SIDEBAR USERPIC -->
						<div class="profile-userpic"></div>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name"></div>

							<div class="profile-usertitle-job">ADMIN</div>
						</div>
						<!-- END SIDEBAR USER TITLE -->
						<!-- SIDEBAR BUTTONS -->
						<div class="profile-userbuttons"></div>
						<!-- END SIDEBAR BUTTONS -->
						<!-- SIDEBAR MENU -->
						<div class="profile-usermenu">
							<ul class="nav">
								<li class="active"><a href="/BanRuou/admin/profile"> <i
										class="icon-settings"></i> Add profile
								</a></li>
							</ul>
						</div>
						<!-- END MENU -->
					</div>
					<!-- END PORTLET MAIN -->
					<!-- PORTLET MAIN -->

					<!-- END PORTLET MAIN -->
				</div>
				<!-- END BEGIN PROFILE SIDEBAR -->
				<!-- BEGIN PROFILE CONTENT -->
				<div class="profile-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet light">
								<div class="portlet-title tabbable-line">
									<div class="caption caption-md">
										<i class="icon-globe theme-font hide"></i> <span
											class="caption-subject font-blue-madison bold uppercase">Profile
											Account</span>
									</div>
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab_1_1" data-toggle="tab">Personal
												Info</a></li>
									</ul>
								</div>
								<div class="portlet-body">
									<div class="tab-content">
										<!-- PERSONAL INFO TAB -->
										<div class="tab-pane active" id="tab_1_1">
											<c:url value="/admin/profile-add" var="add"></c:url>
											<form role="form" action="${add}" method="post"
												enctype="multipart/form-data">
												<input name="userid" value="" hidden="">
												<div class="form-group">
													<label class="control-label">Họ và tên</label> <input
														required type="text"
														placeholder="${accountdetail.fullname}"
														class="form-control" name="name" />
												</div>
												<div class="form-group">
													<label class="control-label">CMND</label> <input required
														type="text" placeholder="${accountdetail.cmnd}"
														class="form-control" name="cmnd" />
												</div>
												<div class="form-group">
													<label class="control-label">Số điện thoại</label> <input
														required type="text" placeholder="${accountdetail.sdt}"
														class="form-control" name="sdt" />
												</div>
												<div class="form-group">
													<label class="control-label">Địa chỉ</label>
													<textarea required class="form-control" rows="3"
														placeholder="${accountdetail.diachi}" name="diachi"></textarea>
												</div>
												<div class="form-group">

													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-preview fileinput-exists thumbnail"
															style="max-width: 200px; max-height: 150px;"></div>
														<div>
															<span class="btn default btn-file"> <span
																class="fileinput-new"> Select image </span> <span
																class="fileinput-exists"> Change </span> <input
																type="file" name="imageLink" value="" />
															</span>
														</div>
													</div>

												</div>
												<div class="margiv-top-10">
													<button type="submit" class="btn green-haze">Save
														Changes</button>
													<a href="" class="btn default"> Cancel </a>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END PROFILE CONTENT -->
			</div>
		</div>
		<!-- END PAGE CONTENT-->
	</div>
</div>