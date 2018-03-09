package beckbi.msgboard.service;

import beckbi.msgboard.dao.JdbcMsgboardDAO;
import beckbi.msgboard.entity.db.Msgboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdbcMsgboardServiceImpl implements JdbcMsgboardService{


    @Autowired
    public JdbcMsgboardDAO jdbcMsgboardDAO;
    /**
     * 添加数据
     *
     * @param name
     * @param msg
     */
    @Override
    public int createMsgboard(String name, String msg){
        return jdbcMsgboardDAO.createMsgboard(name, msg);
    }

    /**
     * 删除一条数据
     *
     * @param id
     */
    @Override
    public int deleteMsgboardById(int id){
        return jdbcMsgboardDAO.deleteMsgboardById(id);
    }

    /**
     *
     * 设置事物级别最低，加快性能
     *
     * @param page
     * @param pagesize
     */
    @Transactional(readOnly = true)
    @Override
    public List<Msgboard> findByPage(int page, int pagesize){
        int start = (page - 1) * pagesize;
        return jdbcMsgboardDAO.findByPage(start, pagesize);
    }

}
