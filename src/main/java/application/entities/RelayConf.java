/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.entities;



import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author MrColombo1985
 */
@Entity
@Table(name = "devicelist", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "address", "name" }) })
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = { "pin", "ip_addr" }) // business key;
@ToString(exclude = { "Desc", "ip_addr", "pin"})
public class RelayConf{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ElementCollection
	@CollectionTable
	@Column(name = "pictures")
	private Set<RelayConfItem> items =  new HashSet<>();

	@Column(name = "desc")
	private String Desc = " No name ";

	@Column(name = "pin")
	private int pin = 22;

	@Column(name = "ip_addr")
	private String ip_addr = "n/a";

	@Column(name = "dp_x")
	private int dp_x = 0;

	@Column(name = "dp_y")
    private int dp_y = 0;

	@Column(name = "dp_desc")
    private String dp_desc = "";

	@Column(name = "dp_v")
    private int dp_v = 1;
}

