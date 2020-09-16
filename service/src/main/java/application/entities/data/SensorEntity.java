package application.entities.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sensor")
@ToString(exclude = {"values", "optionEntities"})
@EqualsAndHashCode(of = {"ipaddress", "macAddress", "description"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SensorEntity {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nameSensor", unique = true)
    private String nameSensor;

    @Column(name = "description")
    private String description;

    @Column(name = "macaddress")
    private String macAddress;

    @Column(name = "pin")
    private Integer pin;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private Set<ValueEntity> valueEntitys = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "arduino_id", nullable = false)
    private ArduinoDeviceEntity arduino;

    @OneToMany(mappedBy = "sensor")
    private Set<OptionEntity> optionEntities = new HashSet<>();
}
