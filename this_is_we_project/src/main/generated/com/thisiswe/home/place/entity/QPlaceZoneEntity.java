package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceZoneEntity is a Querydsl query type for PlaceZoneEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceZoneEntity extends EntityPathBase<PlaceZoneEntity> {

    private static final long serialVersionUID = -698916330L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceZoneEntity placeZoneEntity = new QPlaceZoneEntity("placeZoneEntity");

    public final StringPath place_zone_name = createString("place_zone_name");

    public final com.thisiswe.home.user.entity.QUserEntity placeNum;

    public final NumberPath<Long> placeZoneNum = createNumber("placeZoneNum", Long.class);

    public QPlaceZoneEntity(String variable) {
        this(PlaceZoneEntity.class, forVariable(variable), INITS);
    }

    public QPlaceZoneEntity(Path<? extends PlaceZoneEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceZoneEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceZoneEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceZoneEntity.class, metadata, inits);
    }

    public QPlaceZoneEntity(Class<? extends PlaceZoneEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.placeNum = inits.isInitialized("placeNum") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("placeNum")) : null;
    }

}

