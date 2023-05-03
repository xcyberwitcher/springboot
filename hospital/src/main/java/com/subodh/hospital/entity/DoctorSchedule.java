package com.subodh.hospital.entity;
import java.sql.Time;

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
@Table(name = AppConstatnt.DOCTORSCHEDULE_Details)
public class DoctorSchedule {
	 @Id
	 @GenericGenerator(name ="subodh",strategy = "increment" )
	 @GeneratedValue(generator = "subodh")
	 @Column(name ="id")
     private Long id;
	 @Column(name ="doctorId")
     private Long doctorId;
	 @Column(name ="totalAppointmentSeat")
     private Long totalAppointmentSeat;
	 @Column(name ="scheduleTimings")
     private Time scheduleTimings;
     
}
