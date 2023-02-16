package com.thisiswe.home.club.board.repository.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;


import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.entity.QBoard;
import com.thisiswe.home.club.board.reply.entity.QReply;
import com.thisiswe.home.user.entity.QUserEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
//TODO [SearchBoardRepositoryImpl] 게시판_검색
public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository {

	public SearchBoardRepositoryImpl() {
		super(Board.class);
	}

	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("=============== SearchBoardRepositoryImpl ===============");
		log.info("====================== SearchPage ======================");
		log.info("=============== SearchBoardRepositoryImpl ===============");	
		
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
		
		booleanBuilder.and(expression);
		
		if (type != null) {
			//TODO [SearchBoardRepositoryImpl] 게시판_검색 : null 기준으로 자르기
			String[] typeArr = type.split("");
			
			BooleanBuilder conditionBuilder = new BooleanBuilder();
			
			for(String t: typeArr) {
				switch (t) {
				
				case "t":
					conditionBuilder.or(board.boardTitle.contains(keyword));
					break;

				case "c":
					conditionBuilder.or(board.boardContent.contains(keyword));
					break;
					
				case "w":
					conditionBuilder.or(userEntity.userId.contains(keyword));
					break;
				}
			}
			booleanBuilder.and(conditionBuilder);
		}
		tuple.where(booleanBuilder);
			
		//TODO [SearchBoard] 게시판_검색 : Sort 추가	- 도메인에 있는 sort 가져오기!
		Sort sort = pageable.getSort();
		sort.stream().forEach(order -> {
								Order derction = order.isAscending()? Order.ASC:Order.DESC;
								String prop = order.getProperty();
								
			PathBuilder orderbyExpression = new PathBuilder(Board.class, "board");
			tuple.orderBy(new OrderSpecifier<>(derction, orderbyExpression.get(prop)));
		});
		
		tuple.groupBy(board);
		
		//TODO [SearchBoardRepositoryImpl] 게시판_검색 : Page 처리하기
		tuple.offset(pageable.getOffset());
		tuple.limit(pageable.getPageSize());		
		log.info("=========================================================");
		log.info("=================== tuple ===================> : " + tuple);
		log.info("=========================================================");
		
		List<Tuple> result = tuple.fetch();
		log.info("================== result ==================> : " + result);
		log.info("=========================================================");
		
		long count = tuple.fetchCount();
		log.info("=================== count ===================> : " + count);
		log.info("=========================================================");
		
		return new PageImpl<Object[]>(result.stream()
						.map(t -> t.toArray()).collect(Collectors.toList()), pageable, count);
	}
}
