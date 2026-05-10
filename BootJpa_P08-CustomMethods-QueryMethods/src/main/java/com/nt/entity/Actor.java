package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "JPA_ACTOR_TAB1")
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
public class Actor {
	@Id
    @SequenceGenerator(name = "gen1", sequenceName = "CNO_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Column(name = "ACTOR_ID")
	private Integer Id;

	//@NonNull
	@Column(name = "ACTOR_NAME", length = 25)
	private String name;

	//@NonNull
	@Column(name = "ACTOR_ADDRESS", length = 25)
	private String address;

	//@Transient
	//@NonNull
	@Column(name = "ACTOR_CATEGORY", length = 25)
	private String category;

	//@NonNull
	@Column(name = "ACTOR_FEE")
	private Double fee;

}
