package com.thisiswe.home.board.free.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = 1472411473L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath board_category = createString("board_category");

    public final StringPath board_content = createString("board_content");

    public final NumberPath<Long> board_num = createNumber("board_num", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> board_reg_date = _super.board_reg_date;

    public final StringPath board_title = createString("board_title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> board_update_date = _super.board_update_date;

    public final NumberPath<Integer> board_view = createNumber("board_view", Integer.class);

    public final com.thisiswe.home.user.entity.QUserEntity user_id;

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user_id = inits.isInitialized("user_id") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("user_id")) : null;
    }

}

