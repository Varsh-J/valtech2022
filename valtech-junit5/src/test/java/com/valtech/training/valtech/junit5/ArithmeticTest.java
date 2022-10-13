package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticTest {
	
	private Arithmetic arithmetic;
	private static int ZERO;
	
	
	@Nested
	public  class DivisionTest{
		
		private Arithmetic arithmetic;
		
		public void testDivByZero(){
			arithmetic = new ArithmeticImpl();
			//assertThrows(ArithmeticException.class,() ->{ arithmetic.div(2,ZERO);});
			assertThrows(ArithmeticException.class,() -> {arithmetic.div(2, ZERO);});
		}
		
	}
	
	
	
	
	@Nested
	@DisplayName("this is for testing sub method of the arithmetic")
	
	public static class SubractionTest{
		private Arithmetic arithmetic;
		
		@ParameterizedTest
		@CsvSource({
			" 'subrating 2 postive nos',3,2,1",
		" 'subractin 2 negative nos',-2,-3,1",
		" 'subracting 1 postive 1 negative nos',-2,3,-5"
		})
		
		public void testSub(String name, int a,int b,int res){
			
			 arithmetic = new ArithmeticImpl();
	            assertEquals(res, arithmetic.sub(a, b));
			
			
			
		}
	}
	
	
	@ParameterizedTest
	@CsvSource({
		" 'Adding 2 postive nos',2,3,5",
	" 'adding 2 negative nos',-2,-3,-5",
	" 'Adding 1 postive 1 negative nos',-2,3,1"
	})
	public void testAdd(String name,int a,int b,int res){
		  assertEquals(res,arithmetic.add(a, b));
		
	}
			
		
	
	
	public static Stream<Arguments> argumentsForAdd(){
	
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,4,-1,-2})
	@DisplayName(value="{index} Testing for add with {0} and 0")
	public void testAdd(int a)
	{
		assertEquals(a, arithmetic.add(a, ZERO));
	}
	
	@Test
	@DisplayName("Generic Test Cases for Add..")
	public void testAdd(){
		assertEquals(5, arithmetic.add(2,3));
		assertEquals(5, arithmetic.add(3,2));
		
	}
	
	@BeforeAll
	public static void executeMeFirst(){
		System.out.println("Before All -Executed First");
		ZERO=0;
	}
	
	@AfterAll
	public static void executeMeJustBeforeProgramExits(){
		System.out.println("last method to before execute");
		ZERO=0;
	}
		
	
	@BeforeEach
	public void runBeforeTest() {
		arithmetic = new ArithmeticImpl();
		System.out.println("Run Before..");
	}
	
	@AfterEach
	public void afterTest() {
		System.out.println("Run After..");
		
	}
	@Test 
	public void testHii() {
		// TODO Auto-generated method stub
		System.out.println("Hii");
		

	}
	
	@Test 
	public void testHello() {
		System.out.println("hello");
	}
	

}
