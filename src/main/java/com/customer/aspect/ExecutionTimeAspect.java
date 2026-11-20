package com.customer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.customer.annotation.TrackExecutionTime;

@Aspect 
@Component
public class ExecutionTimeAspect {
    
    private static final Logger log = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around ("@annotation(com.customer.annotation.TrackExecutionTime)")
    public Object trackExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        try{
            
            return proceedingJoinPoint.proceed();
        }finally{
            long end = System.currentTimeMillis();
            log.info("###### EXECUTION Method :"+
                                    proceedingJoinPoint.getSignature().getName()+" : "+
                                    " #### TIME : "+
                                    (end-start));
        }
        
    }
}
