package com.subodh.carwale.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.subodh.carwale.constant.AppConstant;
@Entity
@Table(name = AppConstant.BRAND_INFO)
public class BrandEntity implements Serializable {
	@Id
	@GenericGenerator(name ="subodh",strategy = "increment" )
	@GeneratedValue(generator = "subodh")
	@Column(name = "id")
    private Long id;
	@Column(name = "name")
    private String name;
	@Column(name = "establishedYear")
    private int establishedYear;
	@Column(name = "headQuater")
    private String headQuater;
	@Column(name = "ceoName")
    private String ceoName;
	@Column(name = "brandValue")
    private String brandValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
	public String getHeadQuater() {
		return headQuater;
	}
	public void setHeadQuater(String headQuater) {
		this.headQuater = headQuater;
	}
	public String getCeoName() {
		return ceoName;
	}
	public void setCeoName(String ceoName) {
		this.ceoName = ceoName;
	}
	public String getBrandValue() {
		return brandValue;
	}
	public void setBrandValue(String brandValue) {
		this.brandValue = brandValue;
	}
	
	@Override
	public String toString() {
		return "BrandEntity [id=" + id + ", name=" + name + ", establishedYear=" + establishedYear + ", headQuater="
				+ headQuater + ", ceoName=" + ceoName + ", brandValue=" + brandValue + "]";
	}
    
}
