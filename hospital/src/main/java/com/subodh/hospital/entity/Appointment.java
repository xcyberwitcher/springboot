package com.subodh.hospital.entity;
import java.io.Serializable;
import java.sql.Time;
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
@Table(name = AppConstatnt.Appointment_Details)
public class Appointment implements Serializable {
  @Id
  @GenericGenerator(name ="subodh",strategy = "increment" )
  @GeneratedValue(generator = "subodh")
  @Column(name ="id")
  private Long id;
  @Column(name ="patientId")
  private Long patientId;
  @Column(name ="doctorId")
  private Long doctorId;
  @Column(name ="date")
  private Date date;
  @Column(name ="time")
  private Time time;
  @Column(name ="isConformed")
  private boolean isConformed;
  @Column(name ="prescription")
  private String prescription;
  
}
