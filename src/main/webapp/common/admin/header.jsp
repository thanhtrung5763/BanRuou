<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<div class="page-header navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="/BanRuou/home"> <img src="<c:url value="/templates/web/images/BTALiquors88.jpg"/>"
				alt="logo" class="logo-default" />
			</a>
			<div class="menu-toggler sidebar-toggler hide">
				<!-- DOC: Remove the above "hide" to enable the sidebar toggler button on header -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler"
			data-toggle="collapse" data-target=".navbar-collapse"> </a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<div class="top-menu">
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown dropdown-user"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> <img alt=""
						class="img-circle"
						src="" /> <span
						class="username username-hide-on-mobile">
							${sessionScope.acc.username} </span> <i class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li><a href="/BanRuou/admin/profile-check"> <i
								class="icon-user"></i> My Profile
						</a></li>
						<li><a href="/BanRuou/logout"> <i class="icon-key"></i>
								Log Out
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>
