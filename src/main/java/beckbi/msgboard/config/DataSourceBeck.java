package beckbi.msgboard.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceBeck {

    /*
    @Bean(name = "jdbcSource2")
    @Qualifier("jdbcSource2")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource getDb1Config(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcSource3")
    @Qualifier("jdbcSource3")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource getDb2Config(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="jdbcTemp1")
    public JdbcTemplate getJdbcTemplate1(
            @Qualifier("jdbcSource2") DataSource dataSource
    ){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="jdbcTemp2")
    public JdbcTemplate getJdbcTemplate2(
            @Qualifier("jdbcSource3") DataSource dataSource
    ){
        return new JdbcTemplate(dataSource);
    }
    */

}
