package com.coderfocus.jsondemo;

import org.junit.Test;
import org.w3c.dom.ls.LSInput;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class JsonConvertTest {
    @Test
    public void testObjectToJson() throws Exception {
        User user = new User();
        user.setName("coder");
        user.setAge(18);
        user.setBirthday(new Date());
        JsonConvert.toJson(user);
    }

    @Test
    public void testListToJson() throws Exception {
        User user = new User();
        user.setName("coder");
        user.setAge(18);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        User user1 = new User();
        user1.setName("coder");
        user1.setAge(18);
        user1.setBirthday(new Date());

        List<User> users = Arrays.asList(user,user1);

        JsonConvert.toJson(users);
    }

    @Test
    public void testArrayToJson() throws Exception{
        String[] strs = {"coder","focus","wechat"};
        JsonConvert.toJson(strs);
    }

    @Test
    public void testMapToJson() throws Exception{
        Map<String,Integer> map = new HashMap<>();
        map.put("coder",18);
        map.put("focus",20);
        JsonConvert.toJson(map);
    }
}