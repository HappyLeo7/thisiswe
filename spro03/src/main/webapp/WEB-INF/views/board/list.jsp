<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				게시판 목록
				<button id="regBtn" type="button" class="btn btn-xs pull-right">게시글
					등록</button>
			</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>작성자</th>
							<th>등록일자</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a class="move" href="${board.bno}">
								<c:out value="${board.title}" /></a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.regDate}" /></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${board.updateDate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- /.table-responsive -->

				<!-- 페이지 - Pagination  -->
				<div class='pull-right'>
					<ul class="pagination">
					
						<c:if test="${pageMaker.prev}"> <!-- prev가 T일때 표시해라 -->
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage -1 }">Previous</a>
							</li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}"
									end="${pageMaker.endPage}">
							<li class='paginate_button ${pageMaker.cri.pageNum == num ? "active" : "" }'>
								<a href="${num }">${num}</a></li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}"> <!-- next가 T일때 표시해라 -->
							<li class="paginate_button next">
								<a href="${pageMaker.endPage +1 }">Next</a>
							</li>
						</c:if>
						
					</ul>
				</div>
				<!-- end 페이지 -->
				
				<form id="actionForm" action="/board/list" method="GET">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				</form>
				
				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<!-- 								<button type="button" class="btn btn-primary">Save changes</button> -->
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-6 -->
</div>

<script type="text/javascript">
	$(document).ready(
			function() {
				var result = '<c:out value="${result}"/>';
				
				checkModal(result);
				history.replaceState({}, null, null);

				function checkModal(result) {
					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$(".modal.body").html(
								"게시글 " + parseInt(result) + "번 글이 등록되었습니다.");
					}

					$("#myModal").modal("show");
				}

				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
				
				var actionForm = $("#actionForm");
				
				$(".paginate_button a").on("click", function(e){
					
					e.preventDefault();
					console.log('###### click ######');
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
				})
				
				$(".move").on("click", function(e){
					e.preventDefault();
					actionForm.append("<input type='hidden' name='bno' value='"+ $(this).attr("href")+"'>");
					actionForm.attr("action","/board/get");
					actionForm.submit();
				})
			})
</script>

<%@include file="../includes/footer.jsp"%>
