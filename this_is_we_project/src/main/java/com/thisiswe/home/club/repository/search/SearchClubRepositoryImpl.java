package com.thisiswe.home.club.repository.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.JPQLQuery;
import com.thisiswe.home.club.entity.ClubEntity;
import com.thisiswe.home.club.entity.QClubEntity;
import com.thisiswe.home.user.entity.QUserEntity;

import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SearchClubRepositoryImpl extends QuerydslRepositorySupport implements SearchClubRepository {

	public SearchClubRepositoryImpl() {
//		super(Board.class);
		super(ClubEntity.class);
	}
	

	@Override
	public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
		
		log.info("searchPage.........");
		
		QClubEntity clubEntity = QClubEntity.clubEntity;
	//  QReply reply = QReply.reply;
		QUserEntity userEntity = QUserEntity.userEntity;
		
		JPQLQuery<ClubEntity> jpqlQuery = from(clubEntity);
		jpqlQuery.leftJoin(userEntity).on(clubEntity.userId.eq(userEntity));
		//jpqlQuery.leftJoin(reply).on(reply.board.eq(board));
		
//		JPQLQuery<Tuple> tuple = 
//				jpqlQuery.select(board, member.email, reply.count());
		JPQLQuery<Tuple> tuple = 
				jpqlQuery.select(clubEntity, userEntity
					//	, reply.count()
						);
		
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		BooleanExpression expression = clubEntity.clubNum.gt(0L);
		
		booleanBuilder.and(expression);
		
		if(type != null) {
			
			String[] typeArr = type.split("");
			
			BooleanBuilder conditionBuilder = new BooleanBuilder();
			
			for(String t:typeArr) {
				switch(t) {
				case "N":
					conditionBuilder.or(clubEntity.clubName.contains(keyword));
					break;
				case "C":
					conditionBuilder.or(clubEntity.clubContent.contains(keyword));
					break;
				case "CG":
					conditionBuilder.or(clubEntity.clubCategory.contains(keyword));
					break;
				}
			}
			
			booleanBuilder.and(conditionBuilder);
			
		}
		tuple.where(booleanBuilder);
		
		// sort 추가
		
//		tuple.orderBy(board.bno.desc());
		
		Sort sort = pageable.getSort();
		
		sort.stream().forEach(order -> {
			Order direction = order.isAscending()? Order.ASC:Order.DESC;
			String prop = order.getProperty();
			
			PathBuilder orderByExpression = 
					new PathBuilder<>(ClubEntity.class,"clubEntity");
			tuple.orderBy(new OrderSpecifier(direction, orderByExpression.get(prop)));
		});
		
		tuple.groupBy(clubEntity);
		
		// page 처리
		
		tuple.offset(pageable.getOffset());
		tuple.limit(pageable.getPageSize());
		
		
		
		log.info("---------------------------------------------");
		log.info("tuple : " + tuple);
		log.info("---------------------------------------------");
		
//		List<Board> result = jpqlQuery.fetch();
		List<Tuple> result = tuple.fetch();
		
		log.info("result : "+ result);
		
		long count = tuple.fetchCount();
		
		log.info("count : "+ count);
		
		return new PageImpl<Object[]>(
                result.stream().map(t -> t.toArray())
                .collect(Collectors.toList()),
                pageable,
                count);
		}
	}
