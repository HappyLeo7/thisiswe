<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
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

			<a href="/board/register">asd</a> <a
				href="http://localhost:8090/board/register">asddd</a>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<!-- id="dataTables-example"> -->
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${list }" var="board">
						<tr>
							<td><c:out value="${board.bno }" /></td>
							<td><a href="/board/get?bno=${board.bno}"><c:out
										value="${board.title }" /></a></td>
							<td><c:out value="${board.writer }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regDate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updateDate }" /></td>
						</tr>
					</c:forEach>

				</table>

				<!-- 페이지 표시 -->
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev }">
							<li class="pagenate_button previous">
							<a class="page-link" href="${pageMaker.startPage-1 }">Previous</a></li>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage}">
									
							<li class='paginate_button ${pageMaker.cri.pageNum == num ? "active":""}'><a class="page-link" href="${num}">${num }</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next }">
							<li class="pagenate_button next">
							<a class="page-link" href="${pageMaker.endPage+1 }">Next</a>
							</li>

						</c:if>
					</ul>


				</div>
				<!-- end페이지 -->
				
				<!-- 페이지 링크를 넘겨주기위한 -->
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
				</form>
				<!-- end 페이지 링크를 넘겨주기위한 -->
				
				<!-- /.table-responsive -->

				<!-- Modal -->
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
								<button type="button" class="btn btn-primary">Save
									changes</button>
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
	<!-- /.col-lg-12 -->
</div>


<!-- <script type="text/javascript">
	$(document).ready(
			function() {
				var result = '<c:out value="${result}"/>';

				checkModal(result);

				function checkModal(result) {
					if (result==='') {
						return;
					}
					if (parseInt(result)>0) {
						$(".modal.body").html("게시글" + parseInt(result) + "번 글이 등록되었습니다.")
					}
					$("#myModal").modal("show");
				}
				
				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
			});
</script> -->
<script type="text/javascript">
	$(document).ready(
			function() {
				var result = "<c:out value='${result}'/>";
				//
				checkModal(result);

				//??
				history.replaceState({}, null, null);

				//
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

				//
				$("#regBtn").on("click", function() {
					self.location = "/board/register";
				});
				
				//
				var actionForm = $("#actionForm");
				$(".paginate_button a").on("click",function(e){  //e는 이벤트를 받아오는것
					e.preventDefault();
					console.log('#######click######');
					actionForm.find("input[name='pageNum']").val($(this).attr("href"));
					actionForm.submit();
				})
				
				$(".move").on("click",function(e){
					e.preventDefault();
					actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>")
					actionForm.attr("action","/board/get");
					actionForm.submit();
				})
				
			})
</script>

<!-- /.row -->
<!-- /.row -->
<!-- /.row -->
<!-- /.row -->

<%@include file="../includes/footer.jsp"%>
