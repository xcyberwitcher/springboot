package com.subodh.hospital.dto;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
public class PatientDto implements Serializable{
	private Long id;
	private String name;
	private String email;
	private Date dateOfBirth;
	private Long contactNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	private String remarks;
}
