package com.spring.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.machine.Calculator;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx 
		= new GenericXmlApplicationContext("classpath:com/spring/context/root-context.xml");
		//이거 지금 톰캣이 실행하는거 아니라 컨테이너를 따로 줘야된다. 파라메터가 안되니까 만들어줘야된다.
		//톰캣이 실행되야 web-inf 가 생긴다. 
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		//bean id를 cal로 준걸 찾아서 준다.

		System.out.println("두개의 정수를 입력하세요. ex) 3, 5");
		
		Scanner scann = new Scanner(System.in);
		
		int a = scann.nextInt();
		int b = scann.nextInt();
		scann.nextLine();
		
		//Calculator cal = new Calculator();	
		//set 메서드가 없다. cal 봐라. properties 성격을 갖도록 필드를 구성해야한다.
		//pojo >> 원시 소스코드. 자바가 의존주입이 되게 만들지 않으면 spring 할 수가 없다.
		//new 가 아니다.
		
		
		
		String result="";
		
		System.out.println("1.덧셈\t2.뺄셈\t3.곱셈\t4.나누기");
		System.out.println("연산을 선택하세요.");
		
		String operator = scann.nextLine();
		
		
		switch(operator) {
		case "1" : result = result+cal.sum(a, b); break;
		case "2" : result = result+cal.minus(a, b); break;
		case "3" : result = result+cal.multi(a, b); break;
		case "4" : result = result+cal.div(a, b); break;
		default : System.out.println("연산 선택이 올바르지 않아 프로그램을 종료합니다.");	
		}
		
		System.out.println("연산결과는"+result+"입니다.");
		
	}
}
