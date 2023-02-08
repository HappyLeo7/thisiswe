package com.thisiswe.home.board.notice.service;

import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.thisiswe.home.board.notice.dto.NoticeDTO;
import com.thisiswe.home.board.notice.dto.PageRequestDTO;
import com.thisiswe.home.board.notice.dto.PageResultDTO;
import com.thisiswe.home.board.notice.entity.Notice;
import com.thisiswe.home.board.notice.repository.NoticeRepository;
import com.thisiswe.home.user.entity.UserEntity;

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
		
		Object result = noticeRepository.getNoticeByNoticeNum(noticeNum);
		
		Object[] arr = (Object[]) result;
	
		return entityToNoticeDTO((Notice)arr[0], (UserEntity)arr[1]);
	}

	//TODO [ServiceImpl] 공지사항 - 페이지 목록 불러오기
	/*
	 * @Override public PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO
	 * pageRequestDTO) {
	 * 
	 * log.info("=========================================================");
	 * log.info("========= pageRequestDTO ===========> : " + pageRequestDTO);
	 * log.info("=========================================================");
	 * 
	 * Function<Object[], NoticeDTO> fun = (en -> entityToNoticeDTO((Notice)en[0],
	 * (UserEntity)en[1]));
	 * 
	 * Page<Object[]> result = noticeRepository.searchPage(
	 * pageRequestDTO.getType(), pageRequestDTO.getKeyword(),
	 * pageRequestDTO.getPageable(Sort.by("noticeNum").descending()));
	 * 
	 * log.info("================= result ===================> : " + result);
	 * 
	 * return new PageResultDTO<>(result, fun); }
	 */
	@Override
	public PageResultDTO<NoticeDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	//TODO [ServiceImpl] 공지사항 - 수정
	@Transactional
	@Override
	public void modify(NoticeDTO noticeDTO) {
		
		Notice notice = noticeRepository.getById(noticeDTO.getNoticeNum());
		
		if(notice != null) {
			notice.change(noticeDTO.getNoticeTitle(), noticeDTO.getNoticeContent());
		}
		noticeRepository.save(notice);
	}

	//TODO [ServiceImpl] 공지사항 - 삭제
	@Transactional
	@Override
	public void remove(Long noticeNum) {
		
		noticeRepository.deleteById(noticeNum);
	}


}
