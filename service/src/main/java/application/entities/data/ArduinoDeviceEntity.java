package application.entities.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "arduino", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@ToString(exclude = {"sensorEntities", "deviceEntities"})
@EqualsAndHashCode(exclude = {"sensorEntities", "deviceEntities"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ArduinoDeviceEntity {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "token")
    private String token;
    @Column(name = "ip")
    private String ip;
    @OneToMany(mappedBy = "arduino", fetch = FetchType.LAZY)
    private Set<SensorEntity> sensorEntities = new HashSet<>();
    @OneToMany(mappedBy = "arduino", fetch = FetchType.LAZY)
    private Set<DeviceEntity> deviceEntities = new HashSet<>();
}
