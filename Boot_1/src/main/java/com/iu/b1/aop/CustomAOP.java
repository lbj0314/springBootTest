package com.iu.b1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAOP {
	
	//@Before("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void before() throws Exception {
		System.out.println("Before MemberJoin");
	}
	
	@AfterReturning("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	public void afterReturning() throws Exception {
		System.out.println("After Returning");
	}
	
	@AfterThrowing("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	//예외 발생시에만
	public void afterThrowing() throws Exception {
		System.out.println("After Throwing");
	}
	
	@After("execution(* com.iu.b1.member.MemberService.memberJoin(..))")
	//afterReturning + afterThrowing
	public void after() throws Exception {
		System.out.println("After");
	}
	
	@Around("execution(* com.iu.b1.member.MemberService.memberLogin(..))")
	//다 합친거
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("메서드 실행 전");
		
		Object obj = joinPoint.proceed();
		
		System.out.println("메서드 실행 후");
		
		return obj;
	}
}