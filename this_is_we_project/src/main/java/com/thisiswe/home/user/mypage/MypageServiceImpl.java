package com.thisiswe.home.user.mypage;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final BoardRepository boardRepository;

	
	
//	 게시글 페이지 목록(list)
	@Override
	public MyPageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO, String userId) {
		
	    UserEntity userEntity = userRepository.findByUserId(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	    Function<Board, BoardDTO> func = board -> entityToBoardDTO(board, userEntity, board.getReplyCount());

	    Page<Board> result2 = boardRepository.findAllByUserId(userEntity, pageRequestDTO.getPageable(Sort.by("boardNum").descending()));

	    return new MyPageResultDTO<>(result2, func);
	}
	
	@Override
	public void getUserInfo(String username) {
		// TODO Auto-generated method stub

	}

	// 회원정보 수정 (페이지만들기 해야함)
	@Override
	public void modifyUserInfo(MypageDTO mypageDTO) {
		Optional<UserEntity> result = userRepository.findByUserId(mypageDTO.getUserId());

		if (result.isPresent()) {
			UserEntity userEntity = result.get();
			userEntity.changeNickName(mypageDTO.getUserNickname());

			String userPassword = passwordEncoder.encode(mypageDTO.getUserPassword());
			userEntity.changePassword(userPassword);

			userRepository.save(userEntity);
		}
	}


	// TODO Auto-generated method stub

	@Override
	public void getUserClubs(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertUserImage(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> getUserBoards(String username) {
		// TODO Auto-generated method stub
		return null;
	}


//
//	@Override
//	public List<BoardDTO> getUserBoards(String userId) {
//		List<BoardDTO> boardDTOS;
//		Pageable pageable = .of(page, , sort); //pageable객체를 인스턴스화해준다.
//		List<Board> boards = boardRepository.findAllByUserId(userId, pageable);
//		for (Board board : boards) {
//			// boards에서 boardDto객체로 말아주는 내용
//			return boardDTOS;
//		}
//		return boardDTOS;
//	}

}
