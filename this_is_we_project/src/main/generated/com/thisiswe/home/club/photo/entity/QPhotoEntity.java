package com.thisiswe.home.club.photo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhotoEntity is a Querydsl query type for PhotoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhotoEntity extends EntityPathBase<PhotoEntity> {

    private static final long serialVersionUID = 619476122L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhotoEntity photoEntity = new QPhotoEntity("photoEntity");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final com.thisiswe.home.club.entity.QClubEntity clubNum;

    public final StringPath photoContent = createString("photoContent");

    public final StringPath photoImage = createString("photoImage");

    public final NumberPath<Long> photoNum = createNumber("photoNum", Long.class);

    public final NumberPath<Long> photoView = createNumber("photoView", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.thisiswe.home.club.entity.QClubEntity userId;

    public QPhotoEntity(String variable) {
        this(PhotoEntity.class, forVariable(variable), INITS);
    }

    public QPhotoEntity(Path<? extends PhotoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhotoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhotoEntity(PathMetadata metadata, PathInits inits) {
        this(PhotoEntity.class, metadata, inits);
    }

    public QPhotoEntity(Class<? extends PhotoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.clubNum = inits.isInitialized("clubNum") ? new com.thisiswe.home.club.entity.QClubEntity(forProperty("clubNum"), inits.get("clubNum")) : null;
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.club.entity.QClubEntity(forProperty("userId"), inits.get("userId")) : null;
    }

}

