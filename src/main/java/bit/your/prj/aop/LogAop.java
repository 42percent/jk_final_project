package bit.your.prj.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAop {
	
	@Around("within(bit.your.prj.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		System.out.println(signatureStr + " 시작");
		
		
	try {
		Object obj = joinpoint.proceed();
		
		System.out.println("loggetAOP:" + signatureStr + "메소드가 실행" + new Date());
		
		return obj;
		
	}finally {
		//System.out.println("실행 후:" + System.currentTimeMillis());
		System.out.println(signatureStr + " 종료");
		}
	}
}
