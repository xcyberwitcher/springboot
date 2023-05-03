package com.subodh.hospital.dto;
import java.io.Serializable;
import lombok.Data;
@Data
public class DoctorDto implements Serializable {
	   private Long doctorId;
	   private String name;
	   private Long contactNumber;
	   private String address;
	   private String city;
	   private String state;
	   private String country;
	   private Long pinCode;
	   private Long departmentId;
	   private Long specializationId;
	   
}
