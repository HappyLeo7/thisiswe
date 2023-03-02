
package templates.club.board.controller;

import com.thisiswe.home.club.board.reply.dto.ReplyRequestDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.member.ClubMemberService;
import com.thisiswe.home.place.dto.PlaceReviewDTO;
import com.thisiswe.home.place.dto.PlaceReviewPageRequestDTO;
import com.thisiswe.home.place.entity.PlaceReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.service.ReplyService;
import com.thisiswe.home.user.security.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@RestController
@RequestMapping("/club/board/review")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 게시판-댓글
public class ReplyController {

    private final ReplyService replyService;
    private final ClubMemberService clubMemberService;

    //TODO [Controller] 게시판-댓글 : 전체 조회
    @GetMapping(value = "/boardNum/getReplyList")
    public ResponseEntity<Page<Reply>> getListByBoard(Long boardNum,
                                                      @RequestParam("page") int page,
                                                      @RequestParam("size") int size
    ) {

        page = page - 1;

        return new ResponseEntity<>(replyService.getList(boardNum, page, size), HttpStatus.OK);
    }

    //TODO [Controller] 게시판-댓글 : 등록
    @PostMapping("/")
    public ResponseEntity<Boolean> register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                                            @RequestBody ReplyRequestDTO replyRequestDTO) {

        /** html json 에서 유저 정보를 넣지 않고, Controller에서 세팅해준다. */
        replyRequestDTO.setUserId(userDetailsImpl.getUsername());
        Boolean boardReplyBoolean = replyService.register(replyRequestDTO);

        return new ResponseEntity<Boolean>(boardReplyBoolean, HttpStatus.OK);
    }

    //TODO [Controller] 게시판-댓글 : 수정
    @PutMapping("/{boardReplyNum}")
    public ResponseEntity<Long> modify(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                                       @RequestBody ReplyDTO replyDTO) {

//        log.info("[ReplyController][modify]================================");
//        /** html json 에서 유저 정보를 넣지 않고, Controller에서 세팅해준다. */
//        replyDTO.setUserId(userDetailsImpl.getUsername());
//        log.info("[ReplyController][modify] replyDTO ======> :: " + replyDTO);
//
//        ReplyRequestDTO replyRequestDTO = ReplyRequestDTO.builder()
//                .boardReplyContent(replyDTO.getBoardReplyContent())
//                .userId(userDetailsImpl.getUsername())
//                .boardNum(replyDTO.getBoardNum())
//                .build();
//
//        Long boardReplyNum = replyService.register(replyRequestDTO);
//        log.info("/[ReplyController][modify]===============================");
//
//        return new ResponseEntity<>(boardReplyNum, HttpStatus.OK);
        return null;
    }

    //TODO [Controller] 게시판-댓글 : 삭제
    @DeleteMapping("/{boardReplyNum}")
    public ResponseEntity<String> remove(@PathVariable Long boardReplyNum) {

        log.info("[ReplyController][remove]================================");
        log.info("[ReplyController][remove] boardReplyNum ====> :: " + boardReplyNum);

        replyService.remove(boardReplyNum);
        log.info("/[ReplyController][remove]===============================");

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}