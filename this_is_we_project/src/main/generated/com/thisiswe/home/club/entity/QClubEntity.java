package com.thisiswe.home.club.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClubEntity is a Querydsl query type for ClubEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QClubEntity extends EntityPathBase<ClubEntity> {

    private static final long serialVersionUID = -1489073808L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClubEntity clubEntity = new QClubEntity("clubEntity");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final StringPath clubCategory = createString("clubCategory");

    public final StringPath clubContent = createString("clubContent");

    public final NumberPath<Long> clubHeadCount = createNumber("clubHeadCount", Long.class);

    public final StringPath clubLogo = createString("clubLogo");

    public final StringPath clubLogoUrl = createString("clubLogoUrl");

    public final StringPath clubLogoUuid = createString("clubLogoUuid");

    public final StringPath clubName = createString("clubName");

    public final NumberPath<Long> clubNum = createNumber("clubNum", Long.class);

    public final StringPath clubPlace = createString("clubPlace");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.thisiswe.home.user.entity.QUserEntity userId;

    public QClubEntity(String variable) {
        this(ClubEntity.class, forVariable(variable), INITS);
    }

    public QClubEntity(Path<? extends ClubEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClubEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClubEntity(PathMetadata metadata, PathInits inits) {
        this(ClubEntity.class, metadata, inits);
    }

    public QClubEntity(Class<? extends ClubEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("userId")) : null;
    }

}

