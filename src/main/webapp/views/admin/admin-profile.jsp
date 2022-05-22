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
						<div class="profile-userpic">
							<c:url value="/image?fname=${accountdetail.imageLink}"
								var="imgUrl"></c:url>
							<img src="${imgUrl}" class="img-responsive" alt="">
						</div>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${accountdetail.fullname}</div>
							<div class="profile-usertitle-job">ADMIN</div>

						</div>
						<!-- END SIDEBAR USER TITLE -->
						<!-- SIDEBAR BUTTONS -->
						<div class="profile-userbuttons"></div>
						<!-- END SIDEBAR BUTTONS -->
						<!-- SIDEBAR MENU -->
						<div class="profile-usermenu">
							<ul class="nav">
								<li><a href="/BanRuou/admin/profile-check"> <i
										class="icon-home"></i> Overview
								</a></li>
								<li class="active"><a href="/BanRuou/admin/profile"> <i
										class="icon-settings"></i> Account Settings
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
										<li><a href="#tab_1_2" data-toggle="tab">Change
												Avatar</a></li>
										<li><a href="#tab_1_3" data-toggle="tab">Change
												Password</a></li>
									</ul>
								</div>
								<div class="portlet-body">
									<div class="tab-content">
										<!-- PERSONAL INFO TAB -->
										<div class="tab-pane active" id="tab_1_1">
											<c:url value="/admin/profile-edit" var="edit"></c:url>
											<form role="form" action="${edit}" method="post"
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

												<div class="margiv-top-10">
													<button type="submit" class="btn green-haze">Save
														Changes</button>
													<a href="" class="btn default"> Cancel </a>

												</div>
											</form>
										</div>
										<!-- END PERSONAL INFO TAB -->
										<!-- CHANGE AVATAR TAB -->
										<div class="tab-pane" id="tab_1_2">
											<c:url value="/admin/profile-editimage" var="edit"></c:url>
											<form role="form" action="${edit}" method="post"
												enctype="multipart/form-data">
												<div class="form-group">
													<c:url value="/image?fname=${accountdetail.imageLink}"
														var="imgUrl"></c:url>
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-new thumbnail"
															style="width: 200px; height: 150px;">
															<img class="img-responsive" width="100px" src="${imgUrl}"
																alt="">
														</div>
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
												<div class="margin-top-10">
													<button type="submit" class="btn green-haze">Submit</button>
												</div>
											</form>
										</div>
										<!-- END CHANGE AVATAR TAB -->
										<!-- CHANGE PASSWORD TAB -->
										<div class="tab-pane" id="tab_1_3">
											<form action="#">
												<div class="form-group">
													<label class="control-label">Current Password</label> <input
														type="password" class="form-control" />
												</div>
												<div class="form-group">
													<label class="control-label">New Password</label> <input
														type="password" class="form-control" />
												</div>
												<div class="form-group">
													<label class="control-label">Re-type New Password</label> <input
														type="password" class="form-control" />
												</div>
												<div class="margin-top-10">
													<a href="#" class="btn green-haze"> Change Password </a> <a
														href="#" class="btn default"> Cancel </a>
												</div>
											</form>
										</div>
										<!-- END CHANGE PASSWORD TAB -->
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