package com.subodh.carwale.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.subodh.carwale.constant.AppConstant;
@Entity
@Table(name=AppConstant.ORDER_INFO)
public class OrderDetails implements Serializable {
	 @Id
	 @GenericGenerator(name ="subodh",strategy = "increment" )
	 @GeneratedValue(generator = "subodh")
     @Column(name="id")
	 private Long id;
     @Column(name="brandId")
     private Long brandId;
     @Column(name="paymentMode")
     private String paymentMode;
     @Column(name="orderDate")
     private Date orderDate;
     @Column(name="deliveredDate")
     private Date deliveredDate;
     @Column(name="isDelivered")
     private Boolean isDelivered;
     @Column(name="advancePaid")
     private String advancePaid;
     @Column(name="totalAmountReceived")
     private String totalAmountReceived;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public String getAdvancePaid() {
		return advancePaid;
	}
	public void setAdvancePaid(String advancePaid) {
		this.advancePaid = advancePaid;
	}
	public String getTotalAmountReceived() {
		return totalAmountReceived;
	}
	public void setTotalAmountReceived(String amount) {
		this.totalAmountReceived = amount;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", brandId=" + brandId + ", paymentMode=" + paymentMode + ", orderDate="
				+ orderDate + ", deliveredDate=" + deliveredDate + ", isDelivered=" + isDelivered + ", advancePaid="
				+ advancePaid + ", totalAmountReceived=" + totalAmountReceived + "]";
	}
}
