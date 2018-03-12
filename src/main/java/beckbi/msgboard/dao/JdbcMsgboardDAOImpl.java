package beckbi.msgboard.dao;

import beckbi.msgboard.entity.db.Msgboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JdbcMsgboardDAOImpl implements JdbcMsgboardDAO {

    private Logger logger = LoggerFactory.getLogger(JdbcMsgboardDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * 添加数据
     *
     * @param name
     * @param msg
     */
    @Override
    public int createMsgboard(String name, String msg){
        logger.info("add name:"+name+" msg:"+msg);
        return jdbcTemplate.update("insert into msgboard(name, msg) values(?, ?)",name,msg);
    }

    /**
     * 删除一条数据
     *
     * @param id
     */
    @Override
    public int deleteMsgboardById(int id){
        logger.info("delete id:"+id);
        return jdbcTemplate.update("delete from msgboard where id = ?", id);
    }

    /**
     *
     * 设置事物级别最低，加快性能
     *
     * @param start
     * @param pagesize
     */
    @Transactional(readOnly = true)
    @Override
    public List<Msgboard> findByPage(int start, int pagesize){
        logger.info("find start:"+start+" pagesize:"+pagesize);

        //传递参数返回结果
        String sql = "select * from msgboard order by mtime desc  limit ?, ?";
        Object[] objects = new Object[]{start, pagesize};
        List<Msgboard> list = jdbcTemplate.query(sql,objects, new BeanPropertyRowMapper(Msgboard.class));
        return list;
    }
}

