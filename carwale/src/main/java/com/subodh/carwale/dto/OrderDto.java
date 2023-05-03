package com.subodh.carwale.dto;

public class OrderDto {
   private Long orderId;
   private String amountPaid;
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public String getAmountPaid() {
	return amountPaid;
}
public void setAmountPaid(String amountPaid) {
	this.amountPaid = amountPaid;
}
@Override
public String toString() {
	return "OrderDto [orderId=" + orderId + ", amountPaid=" + amountPaid + "]";
}
   

}
