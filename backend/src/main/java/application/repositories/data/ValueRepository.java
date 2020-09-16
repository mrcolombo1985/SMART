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
        bindings.bind(root.dateUpdate).all((path, value) -> {
            List<? extends LocalDate> dates = new ArrayList<>(value);
            System.out.println("dates->"+dates.size());
            if (dates.size() == 1) {
                return Optional.of(path.eq(dates.get(0)));
            } else {
                LocalDate from = dates.get(0);
                LocalDate to = dates.get(1);
                return Optional.of(path.between(from, to));
            }
        });
        bindings.bind(root.sensor.macAddress).all((path, value) -> {
            List<? extends String> firstNames = new ArrayList<>(value);
            return Optional.of(path.contains(firstNames.get(0)));
        });
        bindings.bind(root.sensor.nameSensor).all((path, value) -> {
            List<? extends String> firstNames = new ArrayList<>(value);
            return Optional.of(path.contains(firstNames.get(0)));
        });
    }
}
