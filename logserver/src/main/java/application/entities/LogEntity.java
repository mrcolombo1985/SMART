package application.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "data")
public class LogEntity {
    public LogEntity(LogDTO data) {
        this.data = data.getData();
        this.programm = data.getProgramm();
        this.module = data.getModule();
        this.method = data.getMethod();
        this.parameters = data.getParameters();
        this.dateUpdate = data.getDateUpdate();
        this.timeUpdate = data.getTimeUpdate();
    }

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valuedata")
    private String data;

    @Column(name = "programm")
    private String programm;

    @Column(name = "module")
    private String module;

    @Column(name = "method")
    private String method;

    @Column(name = "parameters")
    private String parameters;

    @Column(name = "dateU")
    private String dateUpdate;

    @Column(name = "timeU")
    private String timeUpdate;

}
