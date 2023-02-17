/* board 게시판 관련 js */
	 
	/* [START] board_list.html의 스크립트/
	/* [START] board_list.html : 모달창 처리 */
	     var msg = [[${msg}]];
         console.log(msg);
         
         // 112행 class="modal"
         if(msg){
            $(".modal").modal();
         }
     /* [END] board_list.html : 모달창 처리 */
     /* [START] board_list.html : 검색 기능 처리 */    
         // 61행 id="searchForm"
         var searchForm = $("#searchForm");
         
         // 79행 class="btn-search"
         $('.btn-search').click(function(e){
            searchForm.submit();
         });
         
         // 80행 class="btn-clear"
         $('.btn-clear').click(function(e){
            searchForm.empty().submit();
         });
	/* [END] board_list.html : 검색 기능 처리 */       
	/* [END] board_list.html의 스크립트/

		
	/* [START] board_register.html의 스크립트 */
		
	/* [END] board_register.html의 스크립트 */


	/* [START] board_read.html의 스크립트 */	
	
	/* [END] board_read.html의 스크립트 */
		

	/* [START] board_modify.html의 스크립트 */
		$(".modifyBtn").click(function(){
			//confirm 창 - true&false로 확인. // cf) alert는 경고창을 의미함.
			if(!confirm("게시글 수정하실 건가요?")){
				return;
			}
			actionForm.attr("action", "/thisiswe/club/board/modify(boardNum=${boardDTO.boardNum})")
					  .attr("method", "post")
					  .submit();
		})			
			
		var actionForm = $("form");
		
		$(".removeBtn").click(function(){
			actionForm.attr("action", "/board/remove")
					  //post 방식으로 넣어줘
					  .attr("method", "post");
			//반드시 submit을 넣어줘야 삭제로 넘어간다.
			actionForm.submit(); 
		})
			
		$(".listBtn").click(function(){
			var pageInfo = $("input[name='page']");
			var type=$("input[name='type']");
			var keyword=$("input[name='keyword']");
			
			actionForm.empty();
			actionForm.append(pageInfo);
			actionForm.append(type);
			actionForm.append(keyword);
			actionForm.attr("action","/board/list")
					  .attr("method","get");
				
			/* console.log(actionForm.html()); */
			actionForm.submit();
		})
		/* [END] board_modify.html의 스크립트 */
		