package application.repositories.data;

import application.entities.data.QValueEntity;
import application.entities.data.ValueEntity;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ValueRepository extends JpaRepository<ValueEntity, Integer>,
        QuerydslPredicateExecutor<ValueEntity>, QuerydslBinderCustomizer<QValueEntity> {
    @Override
    default public void customize(QuerydslBindings bindings, QValueEntity root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));

    }
}
