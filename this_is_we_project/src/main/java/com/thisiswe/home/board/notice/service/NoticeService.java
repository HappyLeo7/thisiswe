package com.thisiswe.home.board.notice.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.notice.dto.NoticeDTO;
import com.thisiswe.home.board.notice.dto.PageRequestDTO;
import com.thisiswe.home.board.notice.dto.PageResultDTO;
import com.thisiswe.home.board.notice.entity.Notice;
import com.thisiswe.home.user.entity.UserEntity;

//TODO [Service] 공지사항
public interface NoticeService {

	//TODO [Service] 공지사항 - 등록(register)
	Long register(NoticeDTO noticeDTO);
	
	//TODO [Service] 공지사항 - 읽기(get)
	NoticeDTO get(Long noticeNum);
	
	//TODO [Service] 공지사항 - 페이지 불러오기(pageResult)	
	PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
	
	//TODO [Service] 공지사항 - 수정(get)
	void modify(NoticeDTO noticeDTO);
	
	//TODO [Service] 공지사항 - 삭제(get)
	void remove(Long noticeNum);
	
	//TODO [Service] 공지사항 - DTO(WEB)에서 Entity(DB)로
	default Notice noticeDTOToEntity(NoticeDTO noticeDTO) {
		
		UserEntity userEntity = UserEntity.builder().userId(noticeDTO.getUserId()).build();
		
		//공지사항 번호, 카테고리, 제목, 내용, 조회수
		Notice notice = Notice.builder()
						.noticeNum(noticeDTO.getNoticeNum())
						.noticeCategory(noticeDTO.getNoticeCategory())
						.noticeTitle(noticeDTO.getNoticeTitle())
						.noticeContent(noticeDTO.getNoticeContent())
						.noticeView(noticeDTO.getNoticeVew())
						.build();
		
		return notice;
	}
	
	//TODO [Service] 공지사항 - Entity(DB)에서 DTO(WEB)로
	default NoticeDTO entityToNoticeDTO(Notice notice, UserEntity userEntity) {
		
		//공지사항 번호, 카테고리, 제목, 내용, 유저아이디, 수정일, 조회수
		NoticeDTO noticeDTO = NoticeDTO.builder()
								.noticeNum(notice.getNoticeNum())
								.noticeCategory(notice.getNoticeCategory())
								.noticeTitle(notice.getNoticeTitle())
								.noticeContent(notice.getNoticeContent())
								.userId(userEntity.getUserId())
								.updateDate(notice.getUpdateDate())
								.build();
				
		return noticeDTO;
	}

}
