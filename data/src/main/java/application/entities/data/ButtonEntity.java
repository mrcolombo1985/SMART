package application.entities.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "button")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ButtonEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Sensor_Id")
    private SensorEntity sensorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Device_Id")
    private DeviceEntity deviceEntity;

    @Column(name = "Delay")
    private Integer delay;

    @Column(name = "number")
    private Integer number;

}
