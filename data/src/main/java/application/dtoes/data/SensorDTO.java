package application.dtoes.data;

import application.entities.data.SensorEntity;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class SensorDTO {
    private String name = "";
    private String description = "";
    private String address = "";
    private String arduino = "";
    private String pin = "";

    public SensorDTO(SensorEntity data) {
        this.name = data.getNameSensor();
        this.description = data.getDescription();
        this.address = data.getMacAddress();
        this.pin = data.getPin().toString();
        this.arduino = data.getArduino().getName();
    }
}
