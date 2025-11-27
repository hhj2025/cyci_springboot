package kr.soft.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    @Before("execution(* kr.soft.study.api.studyController.*(..))")
    public void beforeAPI(JoinPoint joinPoint){
        log.info("================== ☜(ﾟヮﾟ☜)Before ====================");
        log.info("type-name : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("getName : {}", joinPoint.getSignature().getName());
    }

    @After("execution(* kr.soft.study.api.studyController.*(..))")
    public void afterAPI(JoinPoint joinPoint){
        log.info("================== ༼ つ ◕_◕ ༽つAfter ====================");
        log.info("type-name : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("getName : {}", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* kr.soft.study.api.studyController.*(..))")
    public void afterReturningAPI(JoinPoint joinPoint){
        log.info("================== ༼ つ ◕_◕ ༽つAfterReturning ====================");
        log.info("type-name : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("getName : {}", joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* kr.soft.study.api.studyController.*(..))", throwing = "exception")
    public void afterThrowingAPI(JoinPoint joinPoint, Exception exception){
        log.info("================== ༼ つ ◕_◕ ༽つAfterThrowing ====================");
        log.info("type-name : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("getName : {}", joinPoint.getSignature().getName());
    }

    @Around("execution(* kr.soft.study.api.studyController.*(..))")
    public Object aroundAPI(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("================== ༼ つ ◕_◕ ༽Around Start ====================");
        log.info("type-name : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
        log.info("getName : {}", joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("================== ༼ つ ◕_◕ ༽Around End ====================");

        log.info("class : {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("method : {}", joinPoint.getSignature().getName());
        log.info("실행시간 : {}ms", (end - start));

        return result;
    }
}
