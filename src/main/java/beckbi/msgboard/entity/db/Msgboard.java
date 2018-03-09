
package beckbi.msgboard.entity.db;



import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Msgboard {

    private int id;
    private String name;
    private String msg;
    private Timestamp mtime;

}
