package application.entities.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QArduinoDeviceEntity is a Querydsl query type for ArduinoDeviceEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QArduinoDeviceEntity extends EntityPathBase<ArduinoDeviceEntity> {

    private static final long serialVersionUID = 2044221996L;

    public static final QArduinoDeviceEntity arduinoDeviceEntity = new QArduinoDeviceEntity("arduinoDeviceEntity");

    public final StringPath description = createString("description");

    public final SetPath<DeviceEntity, QDeviceEntity> deviceEntities = this.<DeviceEntity, QDeviceEntity>createSet("deviceEntities", DeviceEntity.class, QDeviceEntity.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ip = createString("ip");

    public final StringPath name = createString("name");

    public final SetPath<SensorEntity, QSensorEntity> sensorEntities = this.<SensorEntity, QSensorEntity>createSet("sensorEntities", SensorEntity.class, QSensorEntity.class, PathInits.DIRECT2);

    public final StringPath token = createString("token");

    public QArduinoDeviceEntity(String variable) {
        super(ArduinoDeviceEntity.class, forVariable(variable));
    }

    public QArduinoDeviceEntity(Path<? extends ArduinoDeviceEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArduinoDeviceEntity(PathMetadata metadata) {
        super(ArduinoDeviceEntity.class, metadata);
    }

}

