package application.entities;

import lombok.*;

import javax.persistence.*;
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
    private LocalDate dateUpdate;
    private LocalTime timeUpdate;
}
