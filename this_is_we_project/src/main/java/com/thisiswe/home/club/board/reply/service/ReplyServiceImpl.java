package com.thisiswe.home.club.board.reply.service;


import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.reply.dto.ReplyDTO;
import com.thisiswe.home.club.board.reply.dto.ReplyRequestDTO;
import com.thisiswe.home.club.board.reply.dto.ReplyResponseDTO;
import com.thisiswe.home.club.board.reply.entity.Reply;
import com.thisiswe.home.club.board.reply.repository.ReplyRepository;
import com.thisiswe.home.club.board.repository.BoardRepository;

import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.member.ClubMemberService;
import com.thisiswe.home.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Map;

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
        Board board = Board.builder().boardNum(replyRequestDTO.getBoardNum()).clubNum(ClubEntity.builder().clubNum(replyRequestDTO.getClubNum()).build()).build();
        UserEntity userEntity = UserEntity.builder().userId(replyRequestDTO.getUserId()).build();
        System.out.println("값이 있숩니까? / " + board.getClubNum().getClubNum() + " / " + userEntity.getUserId());
        if (clubMemberService.checkMember(board.getClubNum().getClubNum(), userEntity.getUserId())) {

            Reply reply = Reply.builder()
                    .userId(userEntity)
                    .boardNum(board)
                    .board(board)
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
    public Page<ReplyResponseDTO> getList(Long boardNum, int page, int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "boardReplyNum");
        Pageable pageable = PageRequest.of(page, size, sort);//pageable객체를 인스턴스화해준다.
        /*	List<Reply> result = replyRepository.getRepliesByBoardOrderByBoardReplyNum(Board.builder().boardNum(boardNum).build()); */


        Page<ReplyResponseDTO> result = replyRepository.findAllByBoardNum(boardRepository.findById(boardNum).get(), pageable).map(ReplyResponseDTO::toDto);
//        Page<Reply> replyPage = replyRepository.findAllByBoardNum(boardRepository.findById(boardNum ).get(), pageable);

        System.out.println("[ReplyServiceImpl][list]=================================");
        System.out.println("[ReplyServiceImpl][list] result ====> :: " + result);
        System.out.println("/[ReplyServiceImpl][list]================================");

        return result;
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
    public boolean remove(ReplyRequestDTO replyRequestDTO, String userId, Long replyNum) {
        Long clubNum = replyRequestDTO.getClubNum();
        System.out.println("제대로 나오나? 리무부 : " + clubNum + ", " + replyNum);
        if (clubMemberService.checkMember(clubNum, userId)) {

            replyRepository.deleteById(replyNum);
            return true;
        } else {
            return false;
        }
    }
}
	