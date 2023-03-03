
package com.thisiswe.home.club.board.reply.controller;

import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.dto.ReplyRequestDTO;
import com.thisiswe.home.club.board.reply.dto.ReplyResponseDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.service.ReplyService;
import com.thisiswe.home.club.member.ClubMemberService;
import com.thisiswe.home.user.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/club/board/review")
@Log4j2
@RequiredArgsConstructor

//TODO [Controller] 게시판-댓글
public class ReplyController {
    private final ReplyService replyService;
    private final ClubMemberService clubMemberService;


    //TODO [Controller] 게시판-댓글 : 전체 조회
    @ResponseBody
    @GetMapping(value = "/boardNum/getReplyList")
    public Page<ReplyResponseDTO> getListByBoard(Long boardNum,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("size") int size) {
        System.out.println("댓글 불러오는건 되나요? boardNum : " + boardNum);
        page = page - 1;
        return replyService.getList(boardNum, page, size);
    }


    //TODO [Controller] 게시판-댓글 : 등록
    @PostMapping("/")
    public ResponseEntity<Boolean> register(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                                            @RequestBody ReplyRequestDTO replyRequestDTO) {
        System.out.println("게시판 댓글 등록은 되나요?");
        /** html json 에서 유저 정보를 넣지 않고, Controller에서 세팅해준다. */
        replyRequestDTO.setUserId(userDetailsImpl.getUsername());
        System.out.println("contents: " + replyRequestDTO.getBoardReplyContent());
        System.out.println("boardNum : " + replyRequestDTO.getBoardNum());
        System.out.println("clubNum : " + replyRequestDTO.getClubNum());
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
    @PostMapping("/remove/")
    public ResponseEntity<Boolean> remove(@RequestBody ReplyRequestDTO replyRequestDTO, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        return new ResponseEntity<>(replyService.remove(replyRequestDTO, userDetails.getUsername(), replyRequestDTO.getBoardNum()), HttpStatus.OK);
    }
}