package com.thisiswe.home.board.notice.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = 315507769L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNotice notice = new QNotice("notice");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath notice_category = createString("notice_category");

    public final StringPath notice_content = createString("notice_content");

    public final NumberPath<Long> notice_num = createNumber("notice_num", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> notice_reg_date = _super.notice_reg_date;

    public final StringPath notice_title = createString("notice_title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> notice_update_date = _super.notice_update_date;

    public final NumberPath<Integer> notice_view = createNumber("notice_view", Integer.class);

    public final com.thisiswe.home.user.entity.QUserEntity user_id;

    public QNotice(String variable) {
        this(Notice.class, forVariable(variable), INITS);
    }

    public QNotice(Path<? extends Notice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNotice(PathMetadata metadata, PathInits inits) {
        this(Notice.class, metadata, inits);
    }

    public QNotice(Class<? extends Notice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user_id = inits.isInitialized("user_id") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("user_id")) : null;
    }

}

