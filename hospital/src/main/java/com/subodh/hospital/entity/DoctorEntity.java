package com.subodh.hospital.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.subodh.hospital.constant.AppConstatnt;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@AllArgsConstructor
@Data
@Table(name = AppConstatnt.Doctor_Details)
public class DoctorEntity implements Serializable {
   @Id
   @GenericGenerator(name ="subodh",strategy = "increment" )
   @GeneratedValue(generator = "subodh")
   @Column(name ="doctorId")
   private Long doctorId;
   @Column(name ="name")
   private String name;
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
   private Long pinCode;
   @Column(name ="departmentId")
   private Long departmentId;
   @Column(name ="specializationId")
   private Long specializationId;
}
