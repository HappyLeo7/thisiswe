package com.thisiswe.home.place.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlaceImageEntitiy is a Querydsl query type for PlaceImageEntitiy
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlaceImageEntitiy extends EntityPathBase<PlaceImageEntitiy> {

    private static final long serialVersionUID = 736033490L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlaceImageEntitiy placeImageEntitiy = new QPlaceImageEntitiy("placeImageEntitiy");

    public final com.thisiswe.home.enetity.QDateEntity _super = new com.thisiswe.home.enetity.QDateEntity(this);

    public final StringPath place_image_url = createString("place_image_url");

    public final StringPath placeImageName = createString("placeImageName");

    public final NumberPath<Long> placeImageNum = createNumber("placeImageNum", Long.class);

    public final StringPath placeImageUuid = createString("placeImageUuid");

    public final QPlaceEntity placeNum;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updateDate = _super.updateDate;

    public QPlaceImageEntitiy(String variable) {
        this(PlaceImageEntitiy.class, forVariable(variable), INITS);
    }

    public QPlaceImageEntitiy(Path<? extends PlaceImageEntitiy> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlaceImageEntitiy(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlaceImageEntitiy(PathMetadata metadata, PathInits inits) {
        this(PlaceImageEntitiy.class, metadata, inits);
    }

    public QPlaceImageEntitiy(Class<? extends PlaceImageEntitiy> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.placeNum = inits.isInitialized("placeNum") ? new QPlaceEntity(forProperty("placeNum"), inits.get("placeNum")) : null;
    }

}

