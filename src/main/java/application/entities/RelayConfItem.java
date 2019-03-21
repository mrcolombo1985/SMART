/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entities;

import lombok.*;

import javax.persistence.*;

/**
 *
 * @author serg
 */
@Embeddable
@Table(name = "optionslist", uniqueConstraints = {
		@UniqueConstraint(columnNames = {}) })
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RelayConfItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "day")
	private int day;

	@Column(name = "hour")
	private int hour;

	@Column(name = "month")
	private int month;

	@Column(name = "year")
	private int year;

	@Column(name = "minutes")
	private int minutes;

	@Column(name = "seconds")
	private int seconds;

	@Column(name = "parameter")
	private int parameter;// 0-time 1-temperature 2-All 3-������

	@ManyToOne

	@Column(name = "sensor")
	private Sensor sensor;

	@Column(name = "parameter_if")
	private int parametrIf;//0 =   1 <    2 >

	@Column(name = "status")
	private boolean status;

	@Column(name = "parametr_value")
	private int parametrValue;
}