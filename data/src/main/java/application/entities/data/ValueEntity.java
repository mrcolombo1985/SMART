package application.entities.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@ToString(exclude = {"sensor"})
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValueEntity {
    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valuedata")
    private Double value;

    @Column(name = "dateU")
    private LocalDate dateUpdate;

    @Column(name = "timeU")
    private LocalTime timeUpdate;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private SensorEntity sensor;

}
