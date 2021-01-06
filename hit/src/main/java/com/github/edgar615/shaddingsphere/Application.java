package com.github.edgar615.shaddingsphere;

import com.github.edgar615.shaddingsphere.entity.User;
import com.github.edgar615.shaddingsphere.entity.UserPassword;
import com.github.edgar615.util.db.SQLBindings;
import com.github.edgar615.util.db.SqlBuilder;
import com.github.edgar615.util.search.Example;
import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class Application implements ApplicationRunner {

    @Autowired
    private  DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {
        shardingTest();
    }

    private void shardingTest() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        for (int i = 10; i < 20; i ++) {
            HintManager hintManager = HintManager.getInstance();
            if (i % 3 == 0) {
                hintManager.addDatabaseShardingValue("user", "ds1");
                hintManager.addDatabaseShardingValue("user_password", "ds0");
                hintManager.addTableShardingValue("user", 0);
                hintManager.addTableShardingValue("user_password", 1);
            } else {
                hintManager.addDatabaseShardingValue("user", "ds0");
                hintManager.addDatabaseShardingValue("user_password", "ds1");
                hintManager.addTableShardingValue("user", 1);
                hintManager.addTableShardingValue("user_password", 0);
            }
            insertUser(jdbcTemplate, i);
            hintManager.close();
        }

        SQLBindings sqlBindings = SqlBuilder.countByExample(User.class, Example.create());
        int count = jdbcTemplate.queryForObject(sqlBindings.sql(), Integer.class);
        System.out.println(count);
    }

    private void insertUser(JdbcTemplate jdbcTemplate, int i) {
        User user = new User();
        user.setUserId(Integer.toUnsignedLong(i));
        user.setNickname("edgar" + i);
        user.setUsername("edgar" + i);
        user.setMail("edgar" + i + "@github.com");
        user.setMobile("180000000" + i);
        SQLBindings sqlBindings = SqlBuilder.insert(user);
        jdbcTemplate.update(sqlBindings.sql(), sqlBindings.bindings().toArray());

        UserPassword userPassword = new UserPassword();
        // 人为将密码的ID设成与用户的奇偶相反
        userPassword.setUserPasswordId(Integer.toUnsignedLong(i + 1));
        userPassword.setUserId(Integer.toUnsignedLong(i));
        userPassword.setPassword("123456");
        sqlBindings = SqlBuilder.insert(userPassword);
        jdbcTemplate.update(sqlBindings.sql(), sqlBindings.bindings().toArray());
    }
}
