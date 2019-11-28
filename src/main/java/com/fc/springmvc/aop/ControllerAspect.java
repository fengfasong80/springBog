package com.fc.springmvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面?
 * @author xubinbin
 */
@Aspect
@Component
public class ControllerAspect {

	/**
	 * 切点?
	 * 切点代表我们要拦截的对象
	 * 目标?
	 * IAdminService就是我们的目标
	 * 代理?
	 * 我们的IAdminService对象实例是通过代理方式来实现的，并不是直接new创建的
	 */
	@Pointcut("execution(* com.fc.springmvc.modules.right.service.IAdminService.getAdminByUserName(..))")
    public void sayHelloBeforePointcut() {

    }

	/**
	 * 通知，是我们切面的具体实现
	 * 织入?
	 * 将logBeforeAdvice和getAdminByUserName从表面上看起来是一个功能的过程
	 */
    @Before("sayHelloBeforePointcut()")
    public void logBeforeAdvice() {
        System.out.println("service通过用户名得到用户信息之前执行");
    }
	
}
