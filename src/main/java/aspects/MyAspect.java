package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    //this interception will run on all methods of ProductService class
    @Before("execution(* services.ProductService.*(..))")
    public void before(){
        System.out.println("Before interception");
    }

    //this interception will run on all methods of ProductService class
    //will execute no matter the method throws exception or not
    @After("execution(* services.ProductService.*(..))")
    public void after(){
        System.out.println("After interception");
    }

    //this interception won't run if method throws exception
    //expression is set to run on all methods of ProductService Class
    @AfterReturning("execution(* services.ProductService.*(..))")
    public void afterReturning(){
        System.out.println("AfterReturning interception");
    }

    //executes only on 1 method
    //printOwnerName method is intercepted and executed with different parameter as below
    @Around("execution(* services.ProductService.printOwnerName(..))")
    public void changingOwnerValue(ProceedingJoinPoint joinPoint){
        try {
            joinPoint.proceed(new Object[] {"Pichai"});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        //you can also do additional stuff on the printOwnerName method
        // 1. Run it many times
        System.out.println("--starts--running 2 times --");
        try {
            joinPoint.proceed();
            System.out.println("....");
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("--ends--running 2 times --");

        // 2. can get values of the intercepted method
        System.out.println(Arrays.stream(joinPoint.getArgs()).toList());
        System.out.println(joinPoint.getClass());

    }
}
