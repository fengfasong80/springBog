package com.fc.springmvc.modules.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.fc.springmvc.modules.right.entity.User;
import com.fc.springmvc.utils.WebContextKit;

public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 该方法会在控制器（Controller）方法前执行，
	 * 其返回值表示是否中断后续操作。
	 * 当其返回值为true时，表示继续向下执行；
	 * 当其返回值为false时，会中断后续的所有操作（包括调用下一个拦截器和控制器类中的方法执行等）。
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute("SESSION_USER");
		if (null == user) {
			//判断前端请求是否是ajax请求
			String requestType = request.getHeader("X-Requested-With"); 
		    	if(requestType == null){//不是ajax请求则跳转到登录页面，否则返回登录超时的json提示信息
		    		response.sendRedirect(request.getContextPath() + "/view/login");
		    		return false;
		    	}
			WebContextKit.renderJson(response, "sessionTimeOut");
			return false;
		}
		return true;
	}

	/**
	 * 该方法会在控制器方法调用之后，且解析视图之前执行。
	 * 可以通过此方法对请求域中的模型和视图做出进一步的修改。
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 该方法会在整个请求完成，即视图渲染结束之后执行。
	 * 可以通过此方法实现一些资源清理、记录日志信息等工作。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	
	
}
