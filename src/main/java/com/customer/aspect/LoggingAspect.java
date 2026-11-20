package com.customer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// @Aspect
// @Component 
// public class LoggingAspect {
//     @Pointcut("execution(* com.customer.service.CustomerService.getAllCustomers(..)) || " +
//                  "execution(* com.customer.service.CustomerService.getCustomer(..))"
//                 )
//     public void pointCut(){}

//     @Before("pointCut()")
//     public void logBefore() {
//         System.out.println("#######Service method started#######");
//     }

//     @After ("execution(* com.customer.service.CustomerService.getCustomer(..))")
//     public void logAfter(){
//         System.out.println("@@@@@@@@@@Service Method AFTER");
//     }


//     @AfterReturning(
//         pointcut = "execution(* com.customer.service.CustomerService.getCustomer(..))",
//         returning = "result"
//     )
//     public void logAfterReturning(){
//         System.out.println("@@@@@@@@@@Service Method AFTER RETURNING");

//     }

//     @AfterThrowing (
//         pointcut = "execution(* com.customer.service.CustomerService.getCustomer(..))",
//         throwing = "exception"
//     )
//     public void logAfterThrowing(Exception exception){
//         System.out.println("@@@@@@@@@@Service Method AFTER THROWING @@@ :" + exception.getMessage());

//     }

//     @Pointcut ("execution(* com.customer.service.CustomerService.*(..))")
//     public void methodTimeExcution(){}

//     @Around ("methodTimeExcution()")
//     public Object methodTimeExcutionImpl(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//         long start = System.currentTimeMillis();
//         // long end = 0L;
//         try{
//             return proceedingJoinPoint.proceed();
           
//         }
        
//         finally{
//             long end = System.currentTimeMillis();
//             System.out.println(
//                     "Method: " +
//                             proceedingJoinPoint.getSignature().getName());

//             System.out.println("######## TIME TAKEN TO EXECUTE: "+ (end-start)+" ######");
//         }
//     }
// }
