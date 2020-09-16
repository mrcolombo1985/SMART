package application.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogEntity is a Querydsl query type for LogEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLogEntity extends EntityPathBase<LogEntity> {

    private static final long serialVersionUID = 297342872L;

    public static final QLogEntity logEntity = new QLogEntity("logEntity");

    public final StringPath data = createString("data");

    public final StringPath dateUpdate = createString("dateUpdate");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath method = createString("method");

    public final StringPath module = createString("module");

    public final StringPath parameters = createString("parameters");

    public final StringPath programm = createString("programm");

    public final StringPath timeUpdate = createString("timeUpdate");

    public QLogEntity(String variable) {
        super(LogEntity.class, forVariable(variable));
    }

    public QLogEntity(Path<? extends LogEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogEntity(PathMetadata metadata) {
        super(LogEntity.class, metadata);
    }

}

