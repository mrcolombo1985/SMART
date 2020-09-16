package application.entities.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSensorEntity is a Querydsl query type for SensorEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSensorEntity extends EntityPathBase<SensorEntity> {

    private static final long serialVersionUID = -448083310L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSensorEntity sensorEntity = new QSensorEntity("sensorEntity");

    public final QArduinoDeviceEntity arduino;

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath macAddress = createString("macAddress");

    public final StringPath nameSensor = createString("nameSensor");

    public final SetPath<OptionEntity, QOptionEntity> optionEntities = this.<OptionEntity, QOptionEntity>createSet("optionEntities", OptionEntity.class, QOptionEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> pin = createNumber("pin", Integer.class);

    public final SetPath<ValueEntity, QValueEntity> valueEntitys = this.<ValueEntity, QValueEntity>createSet("valueEntitys", ValueEntity.class, QValueEntity.class, PathInits.DIRECT2);

    public QSensorEntity(String variable) {
        this(SensorEntity.class, forVariable(variable), INITS);
    }

    public QSensorEntity(Path<? extends SensorEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSensorEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSensorEntity(PathMetadata metadata, PathInits inits) {
        this(SensorEntity.class, metadata, inits);
    }

    public QSensorEntity(Class<? extends SensorEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.arduino = inits.isInitialized("arduino") ? new QArduinoDeviceEntity(forProperty("arduino")) : null;
    }

}

