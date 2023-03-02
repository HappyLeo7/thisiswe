package com.thisiswe.home.club.board.reply.service;

import java.util.List;
import java.util.stream.Collectors;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.dto.ReplyRequestDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.club.board.repository.BoardRepository;

import com.thisiswe.home.club.member.ClubMemberService;
import com.thisiswe.home.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

//TODO [ServiceImpl] 게시글-댓글
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;
    private final ClubMemberService clubMemberService;

    //TODO [ServiceImpl] 게시글-댓글 : 등록
    @Override
    public boolean register(ReplyRequestDTO replyRequestDTO) {
        Board board = Board.builder().boardNum(replyRequestDTO.getBoardNum()).build();
        UserEntity userEntity = UserEntity.builder().userId(replyRequestDTO.getUserId()).build();
        if (clubMemberService.checkMember(board.getClubNum().getClubNum(), userEntity.getUserId())) {

            Reply reply = Reply.builder()
                    .userId(userEntity)
                    .boardNum(board)
                    .boardReplyContent(replyRequestDTO.getBoardReplyContent())
                    .build();
            replyRepository.save(reply);

            return true;
        } else {
            return false;
        }
    }

    //TODO [ServiceImpl] 게시글-댓글 : 전체 조회
    @Override
    public Page<Reply> getList(Long boardNum, int page, int size ) {

        Sort sort = Sort.by(Sort.Direction.DESC, "boardReplyNum");
        Pageable pageable = PageRequest.of(page, size, sort );//pageable객체를 인스턴스화해준다.
        /*	List<Reply> result = replyRepository.getRepliesByBoardOrderByBoardReplyNum(Board.builder().boardNum(boardNum).build()); */


        Page<Reply> result = replyRepository.findAllByBoardNum(boardRepository.findById(boardNum ).get(), pageable);

        System.out.println("[ReplyServiceImpl][list]=================================");
        System.out.println("[ReplyServiceImpl][list] result ====> :: " + result);
        System.out.println("/[ReplyServiceImpl][list]================================");

        return  result;
//                result.stream().map(i -> entityToReplyDTO(i)).collect(Collectors.toList()); //List<replyDTO>
    }

    //TODO [ServiceImpl] 게시글-댓글 : 수정
    @Override
    public void modify(ReplyDTO replyDTO) {

        System.out.println("[ReplyServiceImpl][modify]===============================");
        System.out.println("[ReplyServiceImpl][modify] replyDTO =====> :: " + replyDTO);
        System.out.println("/[ReplyServiceImpl][modify]==============================");

        replyRepository.save(replyDTOToEntity(replyDTO));
    }

    //TODO [ServiceImpl] 게시글-댓글 : 삭제
    @Override
    public void remove(Long boardReplyNum) {

        System.out.println("[ReplyServiceImpl][modify]===============================");
        System.out.println("[ReplyServiceImpl][modify] boardReplyNum => :: " + boardReplyNum);
        System.out.println("/[ReplyServiceImpl][modify]==============================");

        replyRepository.deleteById(boardReplyNum);
    }
}
	