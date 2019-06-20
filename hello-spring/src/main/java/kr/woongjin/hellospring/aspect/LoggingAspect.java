package kr.woongjin.hellospring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private	static final Logger log = 
			LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* kr.woongjin.hellospring.service.*.*(..))") //모든 클래스의 서비스 메소드; 포인트컷 문법 사용.
	public void logBeforeServiceMethods(JoinPoint jointPoint) {
		String mName = jointPoint.getSignature().getName();
		log.info(mName + " 로그 from 로깅 애스팩트");
	}
	
	
}
