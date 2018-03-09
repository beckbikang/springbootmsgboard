package beckbi.msgboard.controller;

import beckbi.msgboard.entity.db.Msgboard;
import beckbi.msgboard.service.JdbcMsgboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController extends SuperController{






    @Autowired
    JdbcMsgboardService jdbcMsgboardService;

    @Value("${msgboard.test}")
    private String localData;

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public String test(){
        String restr = "test it"+msgboardTitle+"<br>";
        restr += localData;

        return restr;
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<Msgboard> db(){
        String restr ="";
        List<Msgboard> list = jdbcMsgboardService.findByPage(1,10);

        return list;
    }

    @RequestMapping(value="/log", method = RequestMethod.GET)
    public void log(){

        logger.debug("log-debug");
        logger.info("log-info");
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
