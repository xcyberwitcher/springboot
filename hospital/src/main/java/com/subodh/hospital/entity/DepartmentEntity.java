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
@AllArgsConstructor
@Data
@Entity
@Table(name = AppConstatnt.Dept_Details)
public class DepartmentEntity implements Serializable {
  @Id
  @GenericGenerator(name ="subodh",strategy = "increment" )
  @GeneratedValue(generator = "subodh")
  @Column(name ="deptId")
  private Long deptId;
  @Column(name ="deptName")
  private String deptName;
  
}
