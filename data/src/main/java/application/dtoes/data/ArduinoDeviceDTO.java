package application.dtoes.data;

import application.entities.data.ArduinoDeviceEntity;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArduinoDeviceDTO {
    private String name;
    private String description;
    private String token;
    private String ip;

    public ArduinoDeviceDTO(ArduinoDeviceEntity data) {
        this.name = data.getName();
        this.description = data.getDescription();
        this.token = data.getToken();
        this.ip = data.getIp();
    }
}
