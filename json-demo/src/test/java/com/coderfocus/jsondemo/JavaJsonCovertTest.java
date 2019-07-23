package com.coderfocus.jsondemo;

import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

public class JavaJsonCovertTest {

    @Test
    public void toJson() throws IOException {
        User user = new User();
        user.setName("coder");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setEmail("coderfocus@qq.com");
        JavaJsonCovert.toJson(user);
    }

    @Test
    public void toObject() throws IOException , ClassNotFoundException{
        JavaJsonCovert.toObject();
    }
}