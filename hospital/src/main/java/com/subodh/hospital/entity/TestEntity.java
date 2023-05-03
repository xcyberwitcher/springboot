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
@Table(name = AppConstatnt.TEST_Details)
public class TestEntity implements Serializable{
	    @Id
	    @GenericGenerator(name ="subodh",strategy = "increment" )
	    @GeneratedValue(generator = "subodh")
	    @Column(name ="id")	
	    private Long Id;
	    @Column(name ="name")	
	    private String name;
	    @Column(name ="date")	
	    private Date date;
	    @Column(name ="doctorId")	
	    private Long doctorId;
	    
}
