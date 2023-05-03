package com.subodh.esop.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.subodh.esop.constant.AppConst;


@Entity
@Table(name=AppConst.EXERCISE_INFO)
public class Exercise implements Serializable{

	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private Long id;
	
	private String grantId;
	
	@ManyToOne(cascade = javax.persistence.CascadeType.ALL)
	
	private VestedOption vestedOptionId;
	
	private Double exerciseOption;
	
	private Double soldOptions;
	
	private String status;
	
	private Date createddate;
	
	private Date modifiedDate;
	
	

	public Exercise() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrantId() {
		return grantId;
	}

	public void setGrantId(String grantId) {
		this.grantId = grantId;
	}

	public VestedOption getVestedOptionId() {
		return vestedOptionId;
	}

	public void setVestedOptionId(VestedOption vestedOptionId) {
		this.vestedOptionId = vestedOptionId;
	}

	public Double getExerciseOption() {
		return exerciseOption;
	}

	public void setExerciseOption(Double exerciseOption) {
		this.exerciseOption = exerciseOption;
	}

	public Double getSoldOptions() {
		return soldOptions;
	}

	public void setSoldOptions(Double soldOptions) {
		this.soldOptions = soldOptions;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", grantId=" + grantId + ", vestedOptionId=" + vestedOptionId
				+ ", exerciseOption=" + exerciseOption + ", soldOptions=" + soldOptions + ", status=" + status
				+ ", createddate=" + createddate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
	
}
