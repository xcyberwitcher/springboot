package com.subodh.hospital.dto;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import lombok.Data;
@Data
public class AppointmentDto implements Serializable{
	 private Long id;
	  private Long patientId;
	  private Long doctorId;
	  private Date date;
	  private Time time;
	  private boolean isConformed;
	  private String prescription;
	  
}
