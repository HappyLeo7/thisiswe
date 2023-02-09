package com.thisiswe.home.club.board.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.entity.QBoard;
import com.thisiswe.home.club.board.reply.entity.QReply;
import com.thisiswe.home.user.entity.QUserEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
//TODO [SearchBoard] 게시판_검색
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

	public SearchBoardRepositoryImpl() {
		super(Board.class);
	}

	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("=========================================================");
		log.info("====================== SearchPage ======================");
		log.info("=========================================================");		
		
		QBoard board = QBoard.board;
		QReply reply = QReply.reply;
		QUserEntity userEntity = QUserEntity.userEntity;
		
		JPQLQuery<Board> jpqlQuery = from(board);
		jpqlQuery.leftJoin(userEntity).on(board.userId.eq(userEntity));
		//reply의 FK는 board.
		jpqlQuery.leftJoin(reply).on(reply.board.eq(board));
		
		JPQLQuery<Tuple> tuple = jpqlQuery.select(board, userEntity, reply.count());
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		BooleanExpression expression = board.boardNum.gt(0L);
		
		if (type != null) {
			//null 기준으로 자르기
			String[] typeArr = type.split("");
			
		}
		
		return null;
	}
}
