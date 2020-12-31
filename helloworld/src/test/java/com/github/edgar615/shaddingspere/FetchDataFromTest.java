package com.github.edgar615.shaddingspere;

import com.github.edgar615.jdbc.codegen.gen.CodegenOptions;
import com.github.edgar615.jdbc.codegen.gen.DaoOptions;
import com.github.edgar615.jdbc.codegen.gen.Generator;

public class FetchDataFromTest {

  public static void main(String[] args) throws Exception {
    CodegenOptions options = new CodegenOptions()
        .setUsername("root")//用户名
        .setPassword("123456") //密码
        .setHost("localhost") //数据库地址
        .setPort(3306) //端口，默认值3306
        .setDatabase("ds0") //数据库
        .setSrcFolderPath("helloworld/src/main/java")//生成JAVA文件的存放目录
        .setDomainPackage("com.github.edgar615.shaddingsphere.entity")//domain类的包名
        .setIgnoreColumnsStr("created_on,updated_on")
        .addGenTable("user")
            .addGenTable("user_password");
    new Generator(options)
            .generate();

  }

}