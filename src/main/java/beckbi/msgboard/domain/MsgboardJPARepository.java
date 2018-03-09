package beckbi.msgboard.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MsgboardJPARepository extends JpaRepository<MsgboardJPA, Long>{

    @Query(value="select* from msgboard order by mtime desc limit :start, :pagesize" ,nativeQuery=true)
    List<MsgboardJPA> findByPage(@Param("start") int start, @Param("pagesize") int pagesize);

}
