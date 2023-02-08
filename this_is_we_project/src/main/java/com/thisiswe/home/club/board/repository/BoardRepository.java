package com.thisiswe.home.club.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thisiswe.home.club.board.entity.Board;

//TODO [Repository] 게시판 - Query
public interface BoardRepository extends JpaRepository<Board, Long> {

}
