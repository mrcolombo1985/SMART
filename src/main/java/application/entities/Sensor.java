/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 *
 * @author serg
 */
@Entity
@Table(name = "sensorlist", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "address", "name" }) })
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = { "name", "address" }) // business key;
@ToString(exclude = { "name", "address", "value"})
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
    private String address;

	@Column(name = "value")
	private float value;

	@Column(name = "x")
    protected int x = 0;

	@Column(name = "y")
    protected int y = 0;

	@OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<RelayConfItem> options;

}
