package com.subodh.hospital.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.subodh.hospital.constant.AppConstatnt;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@Entity
@Table(name = AppConstatnt.Patient_Details)
public class PatientEntity implements Serializable {
	@Id
	@GenericGenerator(name ="subodh",strategy = "increment" )
	@GeneratedValue(generator = "subodh")
	@Column(name ="id")	
	private Long id;
	@Column(name ="name")	
	private String name;
	@Column(name ="email")	
	private String email;
	@Column(name ="dateOfBirth")	
	private Date dateOfBirth;
	@Column(name ="contactNumber")	
	private Long contactNumber;
	@Column(name ="address")	
	private String address;
	@Column(name ="city")	
	private String city;
	@Column(name ="state")	
	private String state;
	@Column(name ="country")	
	private String country;
	@Column(name ="pincode")	
	private Integer pincode;
	@Column(name ="remarks")	
	private String remarks;
	
	
}
