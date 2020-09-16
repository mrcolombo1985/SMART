package application.entities.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDeviceEntity is a Querydsl query type for DeviceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDeviceEntity extends EntityPathBase<DeviceEntity> {

    private static final long serialVersionUID = -1153290194L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDeviceEntity deviceEntity = new QDeviceEntity("deviceEntity");

    public final QArduinoDeviceEntity arduino;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nameDevice = createString("nameDevice");

    public final SetPath<OptionEntity, QOptionEntity> optionEntities = this.<OptionEntity, QOptionEntity>createSet("optionEntities", OptionEntity.class, QOptionEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> pin = createNumber("pin", Integer.class);

    public QDeviceEntity(String variable) {
        this(DeviceEntity.class, forVariable(variable), INITS);
    }

    public QDeviceEntity(Path<? extends DeviceEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDeviceEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDeviceEntity(PathMetadata metadata, PathInits inits) {
        this(DeviceEntity.class, metadata, inits);
    }

    public QDeviceEntity(Class<? extends DeviceEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.arduino = inits.isInitialized("arduino") ? new QArduinoDeviceEntity(forProperty("arduino")) : null;
    }

}

