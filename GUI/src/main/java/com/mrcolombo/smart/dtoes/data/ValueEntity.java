package com.mrcolombo.smart.dtoes.data;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ValueEntity {
    private Double value;
    private String dateUpdate;
    private String timeUpdate;

}
