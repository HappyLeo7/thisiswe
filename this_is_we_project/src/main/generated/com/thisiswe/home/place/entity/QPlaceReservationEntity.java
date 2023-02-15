package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceReservationEntity is a Querydsl query type for PlaceReservationEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceReservationEntity extends EntityPathBase<PlaceReservationEntity> {

    private static final long serialVersionUID = -1668327032L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceReservationEntity placeReservationEntity = new QPlaceReservationEntity("placeReservationEntity");

    public final StringPath place_reservation_name = createString("place_reservation_name");

    public final StringPath place_reservation_tel = createString("place_reservation_tel");

    public final StringPath placeReservationDate = createString("placeReservationDate");

    public final NumberPath<Long> placeReservationHeadcount = createNumber("placeReservationHeadcount", Long.class);

    public final NumberPath<Long> placeReservationNum = createNumber("placeReservationNum", Long.class);

    public final StringPath placeReservationTime = createString("placeReservationTime");

    public final QPlaceZoneEntity plcaeZoneNum;

    public final com.thisiswe.home.user.entity.QUserEntity userId;

    public QPlaceReservationEntity(String variable) {
        this(PlaceReservationEntity.class, forVariable(variable), INITS);
    }

    public QPlaceReservationEntity(Path<? extends PlaceReservationEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceReservationEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceReservationEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceReservationEntity.class, metadata, inits);
    }

    public QPlaceReservationEntity(Class<? extends PlaceReservationEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.plcaeZoneNum = inits.isInitialized("plcaeZoneNum") ? new QPlaceZoneEntity(forProperty("plcaeZoneNum"), inits.get("plcaeZoneNum")) : null;
        this.userId = inits.isInitialized("userId") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("userId")) : null;
    }

}

