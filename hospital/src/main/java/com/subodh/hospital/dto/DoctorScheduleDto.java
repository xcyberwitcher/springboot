package com.subodh.hospital.dto;
import java.io.Serializable;
import java.sql.Time;
import lombok.Data;
@Data
public class DoctorScheduleDto implements Serializable {
	private Long id;
    private Long doctorId;
    private Long totalAppointmentSeat;
    private Time ScheduleTimings;
    
}
