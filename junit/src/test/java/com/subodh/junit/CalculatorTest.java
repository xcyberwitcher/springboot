package com.subodh.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.subodh.junit.test.Calculator;

public class CalculatorTest {
	
	public static Calculator test;
	@BeforeAll
	public static void before() {
		test= new Calculator();
		System.out.println("Before All");
	}
	@AfterAll
	public static void after() {
		test= new Calculator();
		System.out.println("After All");
	}
	
	@Test
	public void testAdd() {
		assertEquals(17, Calculator.add(12, 5));
	}
	@Test
	public void testAddZero() {
		assertEquals(0, Calculator.add(0, 5));
	}
	
       
}
