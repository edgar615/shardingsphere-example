package com.github.edgar615.shaddingsphere;

import com.github.edgar615.shaddingsphere.entity.User;
import com.github.edgar615.util.db.SQLBindings;
import com.github.edgar615.util.db.SqlBuilder;
import com.github.edgar615.util.search.Example;
import org.apache.shardingsphere.api.hint.HintManager;
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
        readTest2();
//        readTest();
//        insertTest();
    }

    private void readTest() {
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        for (int i = 0; i < 10; i ++) {
            SQLBindings sqlBindings = SqlBuilder.findByExample(User.class, Example.create());
            List<User> users = jdbcTemplate.query(sqlBindings.sql(), BeanPropertyRowMapper.newInstance(User.class));
            System.out.println(users.size());
        }
        hintManager.close();
    }

    private void readTest2() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        SQLBindings sqlBindings = SqlBuilder.findById(User.class, 11L);
        List<User> users = jdbcTemplate.query(sqlBindings.sql(), sqlBindings.bindings().toArray(), BeanPropertyRowMapper.newInstance(User.class));
        System.out.println(users.size());
    }

    private void insertTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        User user = new User();
        user.setUserId(1L);
        user.setNickname("edgar");
        user.setUsername("edgar");
        user.setMail("edgar" + "@github.com");
        user.setMobile("18000000000");
        SQLBindings sqlBindings = SqlBuilder.insert(user);
        jdbcTemplate.update(sqlBindings.sql(), sqlBindings.bindings().toArray());
    }

}
