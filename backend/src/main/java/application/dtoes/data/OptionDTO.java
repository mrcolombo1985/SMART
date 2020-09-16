package application.dtoes.data;

import application.entities.data.OptionEntity;
import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class OptionDTO {
    private String name = "";
    private String type = ""; // 1Time 2Sensor
    private String ifType = ""; // 0= 1< 2>
    private String sensorName = "";
    private String deviceName = "";
    private String date = "";
    private String time = "";
    private String data = "";
    private String description = "";

    public OptionDTO(OptionEntity data) {
        this.name = data.getNameOption();
        this.deviceName = data.getDevice().getNameDevice();
        this.type = data.getType().toString();
        this.ifType = data.getIfType().toString();
        this.sensorName = data.getSensor().getNameSensor();
        this.date = data.getDateS().toString();
        this.time = data.getTimeS().toString();
        this.description = data.getDescription();
        this.data = data.getData().toString();
    }
}
