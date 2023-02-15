package com.thisiswe.home.club.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClubMemberEntity is a Querydsl query type for ClubMemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClubMemberEntity extends EntityPathBase<ClubMemberEntity> {

    private static final long serialVersionUID = -795228909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClubMemberEntity clubMemberEntity = new QClubMemberEntity("clubMemberEntity");

    public final NumberPath<Long> clubMemberNum = createNumber("clubMemberNum", Long.class);

    public final NumberPath<Long> clubMemberRole = createNumber("clubMemberRole", Long.class);

    public final NumberPath<Long> clubNum = createNumber("clubNum", Long.class);

    public final com.thisiswe.home.club.entity.QClubEntity userId;

    public QClubMemberEntity(String variable) {
        this(ClubMemberEntity.class, forVariable(variable), INITS);
    }

    public QClubMemberEntity(Path<? extends ClubMemberEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClubMemberEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClubMemberEntity(PathMetadata metadata, PathInits inits) {
        this(ClubMemberEntity.class, metadata, inits);
    }

    public QClubMemberEntity(Class<? extends ClubMemberEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.club.entity.QClubEntity(forProperty("userId"), inits.get("userId")) : null;
    }

}

