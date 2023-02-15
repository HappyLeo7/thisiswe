package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceEntity is a Querydsl query type for PlaceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceEntity extends EntityPathBase<PlaceEntity> {

    private static final long serialVersionUID = 635277002L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceEntity placeEntity = new QPlaceEntity("placeEntity");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final StringPath placeAddress = createString("placeAddress");

    public final StringPath placeBusinessHours = createString("placeBusinessHours");

    public final StringPath placeCaution = createString("placeCaution");

    public final StringPath placeCoordinate = createString("placeCoordinate");

    public final StringPath placeGuide = createString("placeGuide");

    public final StringPath placeHoliday = createString("placeHoliday");

    public final StringPath placeIntroduction = createString("placeIntroduction");

    public final StringPath placeName = createString("placeName");

    public final NumberPath<Long> placeNum = createNumber("placeNum", Long.class);

    public final StringPath placeOneLineIntroduction = createString("placeOneLineIntroduction");

    public final StringPath placePhoneNumber = createString("placePhoneNumber");

    public final StringPath placeRefundRegulations = createString("placeRefundRegulations");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public final com.thisiswe.home.user.entity.QUserEntity userId;

    public QPlaceEntity(String variable) {
        this(PlaceEntity.class, forVariable(variable), INITS);
    }

    public QPlaceEntity(Path<? extends PlaceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceEntity.class, metadata, inits);
    }

    public QPlaceEntity(Class<? extends PlaceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("userId")) : null;
    }

}

