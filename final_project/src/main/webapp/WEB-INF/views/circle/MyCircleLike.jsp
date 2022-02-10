<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!-- 좋아요한 동아리 목록 -->
<!-- Header -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- End of Header -->
<%@ include file="/WEB-INF/views/top.jsp"%>

<!-- ---------------------------------------------------------------------------------------------------------------------- -->

<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

<!-- Main Content -->
		<div id="content">

<!-- ---------------------------------------------------------------------------------------------------------------------- -->

<!-- Begin Page Content -->
		<div class="container-fluid">

<!-- Page Heading -->
			<div class="d-sm-flex align-items-center justify-content-between mb-4">
				<h1 class="h3 mb-0 text-gray-800"> MY 동아리 </h1>
			</div>
			 
			 
			<ul class="nav nav-tabs justify-content-center">
			  <li class="nav-item">
			    <a class="nav-link" href="${ cp }/circle/MyCircleList">신청한 동아리</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link active" aria-current="page" href="${ cp }/circle/MyCircleLike">좋아요한 동아리</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="${ cp }/circle/MyCircle">동아리 관리</a>
			  </li>
			</ul>

			
<!-- Approach -->
			<!-- 2. 내가 좋아요한 동아리 카드 -->
			<div class="row">
						
			<c:choose>
			<c:when test="${ not empty list }">
			<c:forEach var="vo" items="${ list }">
				<div class="col-lg-4 mt-4 mb-4">
			<!-- n번 동아리 목록 -->
			<div class="card shadow mb-3">
				<div class="col-md-12">
					<div class="card-body">
							
					<div class="row g-0">
					<div class="col-md-8"> <!-- 카드본문 왼쪽 (정보) -->
						<div class="card-body">
							<h6 class="card-title"> 
								<a href="${ cp }/circle/CircleDetail?ci_num=${ vo.ci_num }">									
										 ${ vo.ci_title }</a> 
							</h6>
							<p class="card-text">
								<img src="${ cp }/resources/images/circle/${ vo.ci_logofile }" 
									 style="width:50px; height:50px;">
								&nbsp;&nbsp;&nbsp;
								<h6 class="m-0 font-weight-bold text-dark" style="display:inline;"> ${ vo.ci_name } </h6>
							</p>
						</div>
					</div>
					<div class="col-md-4"> <!-- 카드본문 오른쪽 (포스터) -->
						<img src="${ cp }/resources/images/circle/${ vo.ci_imgfile }" 
							 class="img-fluid rounded-start" alt="..." style="width:150px;">
					</div>
					</div>
					</div>
				</div>
			</div> <!-- (1) 동아리 목록 끝 -->
				</div>
			</c:forEach>
			</c:when>
					
			<c:otherwise>
				<h6 class="m-0 font-weight-bold text-danger" style="text-align:center;">찜한 동아리가 없습니다</h6>
			</c:otherwise>
			</c:choose>
			</div><!-- 2. 내가 좋아요한 동아리 카드 끝 -->



		</div> <!-- container-fluid (Main Content의 메인부분) 끝-->
<!-- /.container-fluid -->
			
		</div> <!-- Main Content 끝-->
<!-- End of Main Content -->
			
	</div> <!-- ContentWrapper 끝 -->
<!-- End of Content Wrapper -->	


<!-- Footer -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
<!-- End of Footer -->


	<!-- </div>  -->
<!-- End of Page Wrapper -->
		
<!-- ---------------------------------------------------------------------------------------------------------------------- -->
		
<!-- 스크롤 -->		
<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top">
		<i class="fas fa-angle-up"></i>
	</a>

<!-- 로그아웃 -->
<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		 aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
					<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				
				<div class="modal-body">로그아웃하시려면 '로그아웃' 버튼을 눌러주세요.</div>
					
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
							data-dismiss="modal">취소
					</button>
					<a class="btn btn-primary" href="login.html">로그아웃</a>
				</div>
			</div>
		</div>
	</div>
	
<style>
	#dot {
		list-style:none;
		padding-left:5px;
   	}
   	#dot li {
  		overflow: hidden;
  		text-overflow: ellipsis;
  		white-space: nowrap;
  		width: 300px;
  		height: 20px;
	}
</style>   