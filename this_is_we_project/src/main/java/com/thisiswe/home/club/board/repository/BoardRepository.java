package com.thisiswe.home.club.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.search.SearchBoardRepository;

//TODO [Repository] 게시판 - Query

public interface BoardRepository extends JpaRepository<Board, Long>, SearchBoardRepository{


}
