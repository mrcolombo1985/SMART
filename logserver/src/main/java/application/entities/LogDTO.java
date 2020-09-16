package application.entities;

import lombok.*;

import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "data")
public class LogDTO {
    private String data;
    private String programm;
    private String module;
    private String method;
    private String parameters;
    private String dateUpdate;
    private String timeUpdate;
}
