package application.repositories;

import application.entities.LogEntity;
import application.entities.QLogEntity;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

public interface LogRepository extends JpaRepository<LogEntity, Integer>,
        QuerydslPredicateExecutor<LogEntity>, QuerydslBinderCustomizer<QLogEntity> {
    @Override
    default public void customize(QuerydslBindings bindings, QLogEntity root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));

    }
}
