package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Facility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private String openTime;

	private String closeTime;

	private int latitude;

	private int longitude;

	private String location;

	private boolean activated;
	private boolean deleted;

	@OneToMany(mappedBy = "court", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Court> courts;

}
