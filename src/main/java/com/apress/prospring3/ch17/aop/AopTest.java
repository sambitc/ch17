/**
 * Created on Oct 3, 2011
 */
package com.apress.prospring3.ch17.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * @author Clarence
 *
 */
@Component
@Configurable
@Aspect
public class AopTest {

//	@Before("execution(* com.apress.prospring3.ch17.service..*(..))")
//	public void boforeTarget(JoinPoint joinPoint) throws Throwable {
//		System.out.println("----------------befor advice called----------");
//	}
	
	@AfterReturning("execution(* com.apress.prospring3.ch17.service..*(..))")
	public void afterTarget(JoinPoint joinPoint) throws Throwable {
		System.out.println("====================after advice called----------");
	}

}
