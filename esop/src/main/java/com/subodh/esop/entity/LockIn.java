package com.subodh.esop.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.subodh.esop.constant.AppConst;

@Entity
@Table(name=AppConst.LOCKIN_INFO)
public class LockIn implements Serializable{
	
	
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private Long id;
	
	private String employeeNumber;
	
	private String lockStatus;
	
	private Date createdDate;
	
	private Date modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public LockIn() {
		super();
	}

	@Override
	public String toString() {
		return "LockIn [id=" + id + ", employeeNumber=" + employeeNumber + ", lockStatus=" + lockStatus
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
	

}
