package application.entities.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "device")
@ToString(exclude = {"optionEntities"})
@EqualsAndHashCode(of = {"nameDevice"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeviceEntity {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "nameDevice", unique = true)
    private String nameDevice;

    @Column(name = "pin")
    private Integer pin;

    @ManyToOne
    @JoinColumn(name = "arduino_id", nullable = false)
    private ArduinoDeviceEntity arduino;

    @OneToMany(mappedBy = "device")
    private Set<OptionEntity> optionEntities;
}