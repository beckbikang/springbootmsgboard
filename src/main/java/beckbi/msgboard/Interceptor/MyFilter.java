package beckbi.msgboard.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//过滤器
@WebFilter(filterName="MyFilter", urlPatterns ="/test")
public class MyFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        logger.info("过滤器初始化");
    }

    @Override
    public void destroy() {
        logger.info("filter 销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        logger.info("执行各种过滤操作。。。。。");
        chain.doFilter(request, response);
    }
}