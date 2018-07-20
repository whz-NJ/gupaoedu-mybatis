package com.gupaoedu.mybatis.demo;

import com.gupaoedu.mybatis.beans.Test;
import com.gupaoedu.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by James on 2017-09-08.
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
public class APIDemo
{
    // 编程式方式使用 mybatis 的过程：
    // 加载mybatis xml配置文件（里面有datasource/mapper文件等信息） -> sqlSessionFactory -> SqlSession
    // -> Mapper（动词）-> DbConnection -> DB（名词）
    // 其中的mybatis xml 由 org.apache.ibatis.session.Configuration 类解析（xml里以<configuration>开头）
    // 在 managed /集成式下，通过 java configuration 类实现 mybatis xml类似的功能
    // 工作中使用方式：分析业务 -> 定义表 -> generator 生成我们需要的类
    public static SqlSession getSqlSession() throws FileNotFoundException {
        //配置文件
        File file = new File("src/main/java/com/gupaoedu/mybatis/demo/mybatis-config.xml");
        URL fileURL = null;
        try {
            fileURL = file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream configFile = null;
        try {
            configFile = fileURL.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        InputStream configFile = new FileInputStream(
//                "E:\\workspace\\code\\git\\gupaoedu-mybatis\\src\\main\\java\\com\\gupaoedu\\mybatis\\demo\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {
        TestMapper testMapper = getSqlSession().getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        testMapper.insert(test);
        /**
         * 1. 找到SQL
         * 2. 参数设置
         * 3. 执行
         * 4. 结果映射
         */


    }
}
