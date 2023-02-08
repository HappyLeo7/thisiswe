package com.thisiswe.home.board.notice.service;

import org.springframework.stereotype.Service;

import com.thisiswe.home.board.notice.dto.NoticeDTO;
import com.thisiswe.home.board.notice.dto.PageRequestDTO;
import com.thisiswe.home.board.notice.dto.PageResultDTO;
import com.thisiswe.home.board.notice.entity.Notice;
import com.thisiswe.home.board.notice.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2

//TODO [ServiceImpl] 공지사항
public class NoticeServiceImpl implements NoticeService{
	
	private final NoticeRepository noticeRepository;
	
	//TODO [ServiceImpl] 공지사항 - 등록(register)
	@Override
	public Long register(NoticeDTO noticeDTO) {
		
		log.info("=========================================================");
		log.info("=============== noticeDTO ===============> : " + noticeDTO);
		
		Notice notice = noticeDTOToEntity(noticeDTO);
		
		log.info("================== notice ==================> : " + notice);
		log.info("=========================================================");
		
		noticeRepository.save(notice);
				
		return notice.getNoticeNum();
	}
	
	//TODO [ServiceImpl] 공지사항 - get
	@Override
	public NoticeDTO get(Long noticeNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
