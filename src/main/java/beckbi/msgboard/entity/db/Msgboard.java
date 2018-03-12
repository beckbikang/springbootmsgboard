
package beckbi.msgboard.entity.db;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Setter
@Getter
public class Msgboard implements Serializable{

    private static final long serialVersionUID = -1L;

    private int id;
    private String name;
    private String msg;
    private Timestamp mtime;

    @Override
    public String toString() {
        return "id:"+id+" name:"+name+" msg:"+msg;
    }
}
