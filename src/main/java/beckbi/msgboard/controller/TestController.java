package beckbi.msgboard.controller;

import beckbi.msgboard.domain.MsgboardJPA;
import beckbi.msgboard.domain.MsgboardJPARepository;
import beckbi.msgboard.entity.db.Msgboard;
import beckbi.msgboard.service.JdbcMsgboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController extends SuperController{



    @Autowired
    private MsgboardJPARepository msgboardJPARepository;

    @Autowired
    JdbcMsgboardService jdbcMsgboardService;

    @Value("${msgboard.test}")
    private String localData;



    @RequestMapping(value = "/jpa")
    @ResponseBody
    public String tjpa(){

        String restr = "";
        logger.info("#######start################");


        //查找
        /*
        List<MsgboardJPA> list = msgboardJPARepository.findByPage(1,20);
        logger.info(String.valueOf(list.size()));
        */

        //增加
        MsgboardJPA msgboardJPA = new MsgboardJPA("a1", "a222222");
        MsgboardJPA msgboardJPA1 = msgboardJPARepository.save(msgboardJPA);


        //删除
        long lid = 29;

        msgboardJPARepository.delete(msgboardJPA1.getId());

        /*
        List<MsgboardJPA> list = msgboardJPARepository.findAll();
        logger.info("all:"+String.valueOf(list.size()));
        */
        logger.info("#######end################");


        return restr;
    }


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


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Msgboard> redisTemplate;

    @RequestMapping(value = "/tredis", method = RequestMethod.GET)
    public void testRedis() throws RuntimeException{
        //基本的redis操作
        stringRedisTemplate.opsForValue().set("hi", "123");
        logger.info(stringRedisTemplate.opsForValue().get("hi"));

        //基本的object操作
        Msgboard msgboard = new Msgboard();
        msgboard.setId(111111);
        msgboard.setMsg("haha");
        msgboard.setName("tom");

        //读
        redisTemplate.opsForValue().set("aca",msgboard);
        //写
        Msgboard msgboard1 = redisTemplate.opsForValue().get("aca");
        if(msgboard1 != null){
            logger.info(msgboard1.getName());
        }else {
            logger.info("read faild");
        }

    }

    /*
    @Autowired
    @Qualifier("jdbcTemp1")
    private JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("jdbcTemp2")
    private JdbcTemplate jdbcTemplate2;

    @RequestMapping(value = "/tdt", method = RequestMethod.GET)
    public void testJdbc2() {

        String sql = "insert into msgboard(name,msg)values('jdbcTemplate1','1')";
        jdbcTemplate1.execute(sql);
        String sql2 = "insert into msgboard(name,msg)values('jdbcTemplate2','2')";
        jdbcTemplate2.execute(sql2);
    }
    */

}
