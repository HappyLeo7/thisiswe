package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceCategoryEntity is a Querydsl query type for PlaceCategoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceCategoryEntity extends EntityPathBase<PlaceCategoryEntity> {

    private static final long serialVersionUID = 1160587880L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceCategoryEntity placeCategoryEntity = new QPlaceCategoryEntity("placeCategoryEntity");

    public final StringPath placeCategoryContent = createString("placeCategoryContent");

    public final NumberPath<Long> placeCategoryNum = createNumber("placeCategoryNum", Long.class);

    public final com.thisiswe.home.user.entity.QUserEntity placeNum;

    public QPlaceCategoryEntity(String variable) {
        this(PlaceCategoryEntity.class, forVariable(variable), INITS);
    }

    public QPlaceCategoryEntity(Path<? extends PlaceCategoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceCategoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceCategoryEntity(PathMetadata metadata, PathInits inits) {
        this(PlaceCategoryEntity.class, metadata, inits);
    }

    public QPlaceCategoryEntity(Class<? extends PlaceCategoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.placeNum = inits.isInitialized("placeNum") ? new com.thisiswe.home.user.entity.QUserEntity(forProperty("placeNum")) : null;
    }

}

