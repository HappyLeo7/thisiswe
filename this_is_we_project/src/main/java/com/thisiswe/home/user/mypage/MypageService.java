package com.thisiswe.home.user.mypage;

import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.dto.ClubDTO;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.user.entity.UserEntity;

public interface MypageService {
	
	// 내가 가입한 모임 목록 불러오기
	public MyPageResultDTO<ClubDTO, ClubEntity> getClubList(PageRequestDTO pageRequestDTO, String userId);
	
	// ClubEntity(DB) -> CludDTO(Wed)
	default ClubDTO entityClubToDTO (ClubEntity clubEntity, UserEntity userEntity) {
		//지역, 모임명, 내용, 관심 카테고리, 로고이미지, 인원
		ClubDTO clubDTO = ClubDTO.builder()
				.clubNum(clubEntity.getClubNum())
				.userId(userEntity.getUserId())
				.userNickname(clubEntity.getUserId().getUserNickname())
				.clubPlace(clubEntity.getClubPlace())
				.clubName(clubEntity.getClubName())
				.clubContent(clubEntity.getClubContent())
				.clubCategory(clubEntity.getClubCategory())
				.clubLogo(clubEntity.getClubLogo())
				.clubLogoUuid(clubEntity.getClubLogoUuid())
				.clubLogoUrl(clubEntity.getClubLogoUrl())
				.clubHeadCount(clubEntity.getClubHeadCount())
				.build();
		
		System.out.println("서비스 entitToDTO clubDTO :: "+clubDTO);
		return clubDTO;
		
	}
	
	// TODO [Service] 게시판 - 페이지 목록(list)
	public MyPageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO, String userId);
	
	//TODO [Service] 게시판 - Entity(DB)에서 DTO(WEB)로
	default BoardDTO entityToBoardDTO(Board board, UserEntity userEntity, Long replyCount) {

	    
		//게시판 번호, 카테고리, 제목, 내용, 유저아이디, 수정일, 조회수, 댓글수
		BoardDTO boardDTO = BoardDTO.builder()
				
							.boardNum(board.getBoardNum())
							.boardCategory(board.getBoardCategory())
							.boardTitle(board.getBoardTitle())
							.boardContent(board.getBoardContent())
							.userId(userEntity.getUserId())
							.regDate(board.getRegDate())
							.updateDate(board.getUpdateDate())
							.boardView(board.getBoardView())
							.clubName(board.getClubNum().getClubName())
							.clubNum(board.getClubNum().getClubNum())
							.replyCount(replyCount != null ? replyCount.intValue() : 0)		//replyCount는 Long보다는 int 타입을 사용하기!
							.build();
												
		return boardDTO;
	}
	

	// 회원정보 조회
	void getUserInfo(String username);

	// 회원정보 수정
	void modifyUserInfo(MultipartFile userImageFile, String userNickname, String userPassword, String userId);
	
	// 회원정보 이미지 수정
	void modifyUserImageInfo(MultipartFile userImageFile, String userId);
	
	// 회원정보 비밀번호 수정
	void modifyUserPasswordInfo(String userPassword, String userId);
	
	// 회원정보 닉네임 수정
	void modifyUserNicknameInfo(String userNickname, String userId);
	




	
}