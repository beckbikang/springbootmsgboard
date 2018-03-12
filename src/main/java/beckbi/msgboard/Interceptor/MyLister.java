package beckbi.msgboard.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//监听器
@WebListener
public class MyLister  implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContext) {
        logger.info("监听器初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContext) {
        logger.info("监听器销毁");
    }



}

