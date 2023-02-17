package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceReviewEntity is a Querydsl query type for PlaceReviewEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceReviewEntity extends EntityPathBase<PlaceReviewEntity> {

    private static final long serialVersionUID = 188253954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceReviewEntity placeReviewEntity = new QPlaceReviewEntity("placeReviewEntity");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final com.thisiswe.home.user.entity.QUserEntity placeNum;

    public final StringPath placeReviewContent = createString("placeReviewContent");

    public final NumberPath<Long> placeReviewNum = createNumber("placeReviewNum", Long.class);

    public final NumberPath<Integer> placeReviewRate = createNumber("placeReviewRate", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.thisiswe.home.user.entity.QUserEntity userId;

    public QPlaceReviewEntity(String variable) {
        this(PlaceReviewEntity.class, forVariable(variable), INITS);
    }

    public QPlaceReviewEntity(Path<? extends PlaceReviewEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceReviewEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceReviewEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceReviewEntity.class, metadata, inits);
    }

    public QPlaceReviewEntity(Class<? extends PlaceReviewEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.placeNum = inits.isInitialized("placeNum") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("placeNum")) : null;
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("userId")) : null;
    }

}

