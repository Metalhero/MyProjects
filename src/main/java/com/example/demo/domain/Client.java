package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Client extends Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private	String name;
	private String address;
	private String city;
	private String phone;
	private String mobile;
	private String website;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="countryid", insertable=false, updatable=false)
	private Country country;
	private Long countryid;
	
	@ManyToOne
	@JoinColumn(name="stateid", insertable=false, updatable=false)
	private State state;	
	private Long stateid;
	
	private String details;
}