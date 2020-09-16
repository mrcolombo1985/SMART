package application.entities.video;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCameraEntity is a Querydsl query type for CameraEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCameraEntity extends EntityPathBase<CameraEntity> {

    private static final long serialVersionUID = -1281526326L;

    public static final QCameraEntity cameraEntity = new QCameraEntity("cameraEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath path = createString("path");

    public final StringPath title = createString("title");

    public final StringPath url = createString("url");

    public QCameraEntity(String variable) {
        super(CameraEntity.class, forVariable(variable));
    }

    public QCameraEntity(Path<? extends CameraEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCameraEntity(PathMetadata metadata) {
        super(CameraEntity.class, metadata);
    }

}

