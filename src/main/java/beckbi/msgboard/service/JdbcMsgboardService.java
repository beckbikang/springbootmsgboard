package beckbi.msgboard.service;

import beckbi.msgboard.entity.db.Msgboard;

import java.util.List;

public interface JdbcMsgboardService {

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
     *
     * @param page
     * @param pagesize
     */
    List<Msgboard> findByPage(int page, int pagesize);

}
