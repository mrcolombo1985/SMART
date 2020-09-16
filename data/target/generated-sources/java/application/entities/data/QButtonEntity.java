package application.entities.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QButtonEntity is a Querydsl query type for ButtonEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QButtonEntity extends EntityPathBase<ButtonEntity> {

    private static final long serialVersionUID = 724444170L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QButtonEntity buttonEntity = new QButtonEntity("buttonEntity");

    public final NumberPath<Integer> delay = createNumber("delay", Integer.class);

    public final QDeviceEntity deviceEntity;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final QSensorEntity sensorEntity;

    public QButtonEntity(String variable) {
        this(ButtonEntity.class, forVariable(variable), INITS);
    }

    public QButtonEntity(Path<? extends ButtonEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QButtonEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QButtonEntity(PathMetadata metadata, PathInits inits) {
        this(ButtonEntity.class, metadata, inits);
    }

    public QButtonEntity(Class<? extends ButtonEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.deviceEntity = inits.isInitialized("deviceEntity") ? new QDeviceEntity(forProperty("deviceEntity"), inits.get("deviceEntity")) : null;
        this.sensorEntity = inits.isInitialized("sensorEntity") ? new QSensorEntity(forProperty("sensorEntity"), inits.get("sensorEntity")) : null;
    }

}

