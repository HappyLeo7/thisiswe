package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceZoneTimepirceEntity is a Querydsl query type for PlaceZoneTimepirceEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceZoneTimepirceEntity extends EntityPathBase<PlaceZoneTimepirceEntity> {

    private static final long serialVersionUID = -1567802946L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceZoneTimepirceEntity placeZoneTimepirceEntity = new QPlaceZoneTimepirceEntity("placeZoneTimepirceEntity");

    public final QPlaceZoneEntity placeZoneNum;

    public final NumberPath<Long> placeZonePriceTime = createNumber("placeZonePriceTime", Long.class);

    public final NumberPath<Long> placeZoneTimepricePrice = createNumber("placeZoneTimepricePrice", Long.class);

    public final NumberPath<Long> wePlaceZonePriceNum = createNumber("wePlaceZonePriceNum", Long.class);

    public QPlaceZoneTimepirceEntity(String variable) {
        this(PlaceZoneTimepirceEntity.class, forVariable(variable), INITS);
    }

    public QPlaceZoneTimepirceEntity(Path<? extends PlaceZoneTimepirceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceZoneTimepirceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceZoneTimepirceEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceZoneTimepirceEntity.class, metadata, inits);
    }

    public QPlaceZoneTimepirceEntity(Class<? extends PlaceZoneTimepirceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.placeZoneNum = inits.isInitialized("placeZoneNum") ? new QPlaceZoneEntity(forProperty("placeZoneNum"), inits.get("placeZoneNum")) : null;
    }

}

