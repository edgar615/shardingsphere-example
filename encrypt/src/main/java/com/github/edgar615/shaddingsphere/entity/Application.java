package com.github.edgar615.shaddingsphere.entity;

import com.github.edgar615.util.db.SQLBindings;
import com.github.edgar615.util.db.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private  DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {
//        insert();
        read();
    }

    private void read() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SQLBindings sqlBindings = SqlBuilder.findById(EncryptUser.class, 11L);
        List<EncryptUser> users = jdbcTemplate.query(sqlBindings.sql(), sqlBindings.bindings().toArray(), BeanPropertyRowMapper.newInstance(EncryptUser.class));
        System.out.println(users);
    }

    private void insert() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        for (int i = 10; i < 20; i ++) {
            EncryptUser user = new EncryptUser();
            user.setUserId(Integer.toUnsignedLong(i));
            user.setUsername("edgar" + i);
            user.setPassword("123456");
            SQLBindings sqlBindings = SqlBuilder.insert(user);
            jdbcTemplate.update(sqlBindings.sql(), sqlBindings.bindings().toArray());
        }
    }
}
