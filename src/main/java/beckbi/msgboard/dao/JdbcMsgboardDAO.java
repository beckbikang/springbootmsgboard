package beckbi.msgboard.dao;

import beckbi.msgboard.entity.db.Msgboard;

import java.util.List;

public interface JdbcMsgboardDAO {

    /**
     * 添加数据
     *
     * @param name
     * @param msg
     */
    int createMsgboard(String name, String msg);

    /**
     * 删除一条数据
     *
     * @param id
     */
    int deleteMsgboardById(int id);

    /**
     *
     * @param start
     * @param pagesize
     * @return
     */
    List<Msgboard> findByPage(int start, int pagesize);
}
