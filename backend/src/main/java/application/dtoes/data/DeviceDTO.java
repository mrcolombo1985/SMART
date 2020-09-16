package application.dtoes.data;

import application.entities.data.DeviceEntity;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class DeviceDTO {
    private String name = "";
    private String description = "";
    private String pin = "";
    private String arduino = "";

    public DeviceDTO(DeviceEntity data) {
        this.name = data.getNameDevice();
        this.description = data.getDescription();
        this.pin = data.getPin().toString();
        this.arduino = data.getArduino().getName();
    }
}
