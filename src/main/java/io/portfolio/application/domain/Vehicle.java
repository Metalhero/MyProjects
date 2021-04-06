package io.portfolio.application.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Vehicle {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	private String name;
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate;
	private String description;
	private String power;
	private String fuelCapacity;
	private String netWeight;

	@ManyToOne
	@JoinColumn(name="employeeid", insertable=false, updatable=false)
	private Employee inCharge;
	private Long employeeid;


	@ManyToOne
	@JoinColumn(name="locationid", insertable=false, updatable=false)	
	private Location currentLocation;
	private Long locationid;
	
	private String remarks;	
}
