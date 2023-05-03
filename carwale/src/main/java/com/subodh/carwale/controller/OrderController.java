package com.subodh.carwale.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subodh.carwale.constant.AppConstant;
import com.subodh.carwale.dto.BookDto;
import com.subodh.carwale.dto.OrderDto;
import com.subodh.carwale.service.OrderService;
@RestController
@RequestMapping(value = AppConstant.FORWARDS_SLASH)
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping(value = AppConstant.BOOK_ORDER)
    public void book(@RequestBody BookDto bookDto) {
		orderService.saveBookOrder(bookDto);
    }
	@PostMapping(value = AppConstant.DELIVER_ORDER)
    public void book(@RequestBody OrderDto orderDto) {
		orderService.saveDeliverOrder(orderDto);
    }
	
}
