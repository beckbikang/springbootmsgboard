package beckbi.msgboard.Interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
@Configuration
public class MyInterceptor extends WebMvcConfigurerAdapter{

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("开始拦截");
                return true;
            }
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                logger.info("处理请求完成后视图渲染之前的处理操作");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                logger.info("视图渲染之后的操作");
            }
        }).addPathPatterns("/**").excludePathPatterns("/tredis");
        super.addInterceptors(registry);
    }
}
