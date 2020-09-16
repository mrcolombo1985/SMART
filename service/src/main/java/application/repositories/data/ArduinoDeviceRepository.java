package application.repositories.data;

import application.entities.data.ArduinoDeviceEntity;
import application.entities.data.QArduinoDeviceEntity;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ArduinoDeviceRepository extends JpaRepository<ArduinoDeviceEntity, Integer>,
        QuerydslPredicateExecutor<ArduinoDeviceEntity>, QuerydslBinderCustomizer<QArduinoDeviceEntity> {

    @Override
    default void customize(QuerydslBindings bindings, QArduinoDeviceEntity root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));

        bindings.bind(root.description).all((path, value) -> {
            List<? extends String> descriptionList = new ArrayList<>(value);
            return Optional.of(path.contains(descriptionList.get(0)));
        });
        bindings.bind(root.name).all((path, value) -> {
            List<? extends String> macAddressList = new ArrayList<>(value);
            return Optional.of(path.contains(macAddressList.get(0)));
        });

    }
}
