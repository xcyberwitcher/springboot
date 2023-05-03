package com.subodh.carwale.dto;

public class BookDto {
    private Long brandId;
    private String paymentMode;
    private String advancePaid;
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
	public String getAdvancePaid() {
		return advancePaid;
	}
	public void setAdvancePaid(String advancePaid) {
		this.advancePaid = advancePaid;
	}
	@Override
	public String toString() {
		return "BookDto [brandId=" + brandId + ", paymentMode=" + paymentMode + ", advancePaid=" + advancePaid + "]";
	}
}
