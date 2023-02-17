package com.thisiswe.home.board.reply.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = -2065438225L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply reply = new QReply("reply");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final com.thisiswe.home.board.free.entity.QBoard board_num;

    public final StringPath board_reply_content = createString("board_reply_content");

    public final NumberPath<Long> board_reply_num = createNumber("board_reply_num", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> board_reply_regDate = _super.board_reply_regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> board_reply_updateDate = _super.board_reply_updateDate;

    public final com.thisiswe.home.user.entity.QUserEntity user_id;

    public QReply(String variable) {
        this(Reply.class, forVariable(variable), INITS);
    }

    public QReply(Path<? extends Reply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply(PathMetadata metadata, PathInits inits) {
        this(Reply.class, metadata, inits);
    }

    public QReply(Class<? extends Reply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board_num = inits.isInitialized("board_num") ? new com.thisiswe.home.board.free.entity.QBoard(forProperty("board_num"), inits.get("board_num")) : null;
        this.user_id = inits.isInitialized("user_id") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("user_id")) : null;
    }

}

