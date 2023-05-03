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
@Table(name=AppConstant.MODEL_INFO)
public class ModelEntity implements Serializable{
	@Id
	@GenericGenerator(name ="subodh",strategy = "increment" )
	@GeneratedValue(generator = "subodh")
    @Column(name="id")
	private Long id;
    @Column(name="modelName")
	private String modelName;
    @Column(name="brandId")
	private String brandId;
    @Column(name="price")
	private Double price;
    @Column(name="type")
	private String type;
    @Column(name="color")
	private String color;
    @Column(name="version")
	private String version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "ModelEntity [id=" + id + ", modelName=" + modelName + ", brandId=" + brandId + ", price=" + price
				+ ", type=" + type + ", color=" + color + ", version=" + version + "]";
	}
	
}
