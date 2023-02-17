package com.thisiswe.home.club.calendar.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCalendarEntity is a Querydsl query type for CalendarEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCalendarEntity extends EntityPathBase<CalendarEntity> {

    private static final long serialVersionUID = 1794601200L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalendarEntity calendarEntity = new QCalendarEntity("calendarEntity");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final StringPath clubCalendarContent = createString("clubCalendarContent");

    public final StringPath clubCalendarDate = createString("clubCalendarDate");

    public final NumberPath<Long> clubCalendarHeadCount = createNumber("clubCalendarHeadCount", Long.class);

    public final NumberPath<Long> clubCalendarNum = createNumber("clubCalendarNum", Long.class);

    public final StringPath clubCalendarPlace = createString("clubCalendarPlace");

    public final NumberPath<Long> clubCalendarPrice = createNumber("clubCalendarPrice", Long.class);

    public final StringPath clubCalendarTime = createString("clubCalendarTime");

    public final StringPath clubCalendarTitle = createString("clubCalendarTitle");

    public final com.thisiswe.home.club.entity.QClubEntity clubNum;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.thisiswe.home.club.entity.QClubEntity userId;

    public QCalendarEntity(String variable) {
        this(CalendarEntity.class, forVariable(variable), INITS);
    }

    public QCalendarEntity(Path<? extends CalendarEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCalendarEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCalendarEntity(PathMetadata metadata, PathInits inits) {
        this(CalendarEntity.class, metadata, inits);
    }

    public QCalendarEntity(Class<? extends CalendarEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clubNum = inits.isInitialized("clubNum") ? new com.thisiswe.home.club.entity.QClubEntity(forProperty("clubNum"), inits.get("clubNum")) : null;
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.club.entity.QClubEntity(forProperty("userId"), inits.get("userId")) : null;
    }

}

