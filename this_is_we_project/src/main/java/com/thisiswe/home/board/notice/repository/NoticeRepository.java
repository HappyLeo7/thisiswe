package com.thisiswe.home.board.notice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.board.notice.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long>{

}
