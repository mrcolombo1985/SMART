package application.dtoes.data;

import application.entities.data.ValueEntity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ValueDTO {
    private String value;
    private String dateUpdate;
    private String timeUpdate;
    private String sensor;

    public ValueDTO(ValueEntity data) {
        System.out.println(data.toString());
        this.dateUpdate = data.getDateUpdate().toString();
        this.sensor = data.getSensor().getNameSensor();
        this.timeUpdate = data.getTimeUpdate().toString();
        this.value = data.getValue().toString();
    }
}
