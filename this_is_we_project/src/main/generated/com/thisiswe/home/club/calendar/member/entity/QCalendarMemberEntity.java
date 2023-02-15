package com.thisiswe.home.club.calendar.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCalendarMemberEntity is a Querydsl query type for CalendarMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCalendarMemberEntity extends EntityPathBase<CalendarMemberEntity> {

    private static final long serialVersionUID = -1728267954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalendarMemberEntity calendarMemberEntity = new QCalendarMemberEntity("calendarMemberEntity");

    public final NumberPath<Long> clubCalendarMemberNum = createNumber("clubCalendarMemberNum", Long.class);

    public final com.thisiswe.home.club.calendar.entity.QCalendarEntity clubCalendarNum;

    public final com.thisiswe.home.club.calendar.entity.QCalendarEntity clubNum;

    public final com.thisiswe.home.club.calendar.entity.QCalendarEntity userId;

    public QCalendarMemberEntity(String variable) {
        this(CalendarMemberEntity.class, forVariable(variable), INITS);
    }

    public QCalendarMemberEntity(Path<? extends CalendarMemberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCalendarMemberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCalendarMemberEntity(PathMetadata metadata, PathInits inits) {
        this(CalendarMemberEntity.class, metadata, inits);
    }

    public QCalendarMemberEntity(Class<? extends CalendarMemberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clubCalendarNum = inits.isInitialized("clubCalendarNum") ? new com.thisiswe.home.club.calendar.entity.QCalendarEntity(forProperty("clubCalendarNum"), inits.get("clubCalendarNum")) : null;
        this.clubNum = inits.isInitialized("clubNum") ? new com.thisiswe.home.club.calendar.entity.QCalendarEntity(forProperty("clubNum"), inits.get("clubNum")) : null;
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.club.calendar.entity.QCalendarEntity(forProperty("userId"), inits.get("userId")) : null;
    }

}

