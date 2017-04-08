package com.fruit.sales.web.integration.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SystemLogAspect {

	private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	
	//Controller层切点  
//	@Pointcut("execution (* com.fruit.sales.web.controller..*(..))")//会拦截所有定义的方法
	@Pointcut("@annotation(com.fruit.sales.web.integration.aop.SystemLog)")		//只针对@annotation
	public void controllerAspect(){
		
	}
	
	@Before("controllerAspect()")
	public void doBefore(JoinPoint jointPoint){
		
		String className = jointPoint.getTarget().getClass().getName();  
		String methodName = jointPoint.getSignature().getName();
		
		try {
			logger.info(getControllerMethodDescription(jointPoint));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
   /* @param joinPoint 切点 
    * @return 方法描述 
    * @throws Exception 
    */  
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {  
       String targetName = joinPoint.getTarget().getClass().getName();  
       String methodName = joinPoint.getSignature().getName();  
       Object[] arguments = joinPoint.getArgs();  
       Class targetClass = Class.forName(targetName);  
       Method[] methods = targetClass.getMethods();  
       String description = "";  
        for (Method method : methods) {  
            if (method.getName().equals(methodName)) {  
               Class[] clazzs = method.getParameterTypes();  
                if (clazzs.length == arguments.length) {  
                   description = method.getAnnotation(SystemLog.class).description();  
                    break;  
               }  
           }  
       }  
        return targetName + "." + methodName + ":" + description;  
   } 
	
}
