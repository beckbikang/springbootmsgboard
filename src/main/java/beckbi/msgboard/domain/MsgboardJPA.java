package beckbi.msgboard.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "msgboard")
public class MsgboardJPA {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="msg")
    private String msg;

    private Timestamp mtime;

    public MsgboardJPA(){}

    public MsgboardJPA(String name, String msg){
        this.name = name;
        this.msg = msg;
    }
}
