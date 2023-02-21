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
import com.thisiswe.home.club.board.dto.PageResultDTO;
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

	// 게시글 페이지 목록(list)
	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		Function<Object[], BoardDTO> func = 
				(en -> entityToBoardDTO((Board)en[0], (UserEntity)en[1], (Long)en[2]));
			
		Page<Object[]> result = boardRepository.searchPage(
					pageRequestDTO.getType(),
					pageRequestDTO.getKeyword(),
					pageRequestDTO.getPageable(Sort.by("boardNum").descending()));								

		return new PageResultDTO<>(result, func);
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




}
