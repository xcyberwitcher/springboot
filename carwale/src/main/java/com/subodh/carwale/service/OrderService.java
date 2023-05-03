package com.subodh.carwale.service;
import java.sql.Date;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subodh.carwale.dto.BookDto;
import com.subodh.carwale.dto.OrderDto;
import com.subodh.carwale.entity.OrderDetails;
import com.subodh.carwale.repository.OrderRepository;
@Service
public class OrderService {
	 @Autowired
	 private OrderRepository orderRepository;
	 
	 public void saveBookOrder(BookDto dto) { 
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setBrandId(dto.getBrandId());
		orderDetails.setAdvancePaid(dto.getAdvancePaid());
	    orderDetails.setPaymentMode(dto.getPaymentMode());
	    orderDetails.setIsDelivered(false);
	    orderDetails.setOrderDate(Date.valueOf(LocalDate.now()));
	    orderDetails.setTotalAmountReceived(dto.getAdvancePaid());
	    orderRepository.save(orderDetails);
	 }
	 public void saveDeliverOrder(OrderDto dto) {
	   System.out.println(dto);
	   OrderDetails details = orderRepository.findById(dto.getOrderId()).get();
	   System.out.println(details);
	   LocalDate localDate = LocalDate.now();
	   details.setDeliveredDate(Date.valueOf(localDate));
	   details.setIsDelivered(true);
	   String amount = details.getAdvancePaid()+dto.getAmountPaid();
	   details.setTotalAmountReceived(amount);
	   orderRepository.save(details);   
	   
	 }
}
