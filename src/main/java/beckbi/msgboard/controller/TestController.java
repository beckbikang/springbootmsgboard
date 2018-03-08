package beckbi.msgboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends SuperController{


    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${msgboard.test}")
    private String localData;

    //@Value("${log4j.rootCategory}")
    //private String logconfig;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        String restr = "test it"+msgboardTitle+"<br>";
        restr += localData;

        return restr;
    }

    @RequestMapping(value="/log", method = RequestMethod.GET)
    public void log(){

        this.logger.debug("log-debug");
        this.logger.info("log-info");x
        logger.error("error");

    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void testException() throws Exception{
        throw new Exception("catch exception");
    }

    @RequestMapping(value = "/null", method = RequestMethod.GET)
    public void testExceptionNull() throws NullPointerException{
        throw new NullPointerException("null exception");
    }

    @RequestMapping(value = "/myex", method = RequestMethod.GET)
    public void testMyException() throws MyException{
        throw new MyException("catch my exception");
    }



    @RequestMapping(value = "/runex", method = RequestMethod.GET)
    public void testRunException() throws RuntimeException{
        throw new RuntimeException("catch my exception");
    }

}
