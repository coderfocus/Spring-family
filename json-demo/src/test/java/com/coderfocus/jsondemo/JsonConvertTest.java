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
        user.setEmail("coderfocus@qq.com");
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

    @Test
    public void testToUser() throws Exception{
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        User user = JsonConvert.toUser(json);
        System.out.println(user);
    }

    @Test
    public void testToUserNoEmail() throws Exception{
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000}";
        User user = JsonConvert.toUser(json);
        System.out.println(user);
    }


    /** 
    * @Description: 忽略序列化某些字段；时间格式化；
    * @param: []
    * @return: void 
    * @Author: songwenjie
    * @Date: 2019/7/23 
    */ 
    @Test
    public void testObjectToJsonIgnoreEmail() throws Exception {
        UserWithAnnotation user = new UserWithAnnotation();
        user.setName("coder");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setEmail("coderfocus@qq.com");
        JsonConvert.toJson(user);
    }

    /**
    * @Description: 忽略反序列化某些字段
    * @param: []
    * @return: void
    * @Author: songwenjie
    * @Date: 2019/7/23
    */
    @Test
    public void testToUserWithAnnotationIgnoreEmail() throws Exception{
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        UserWithAnnotation user = JsonConvert.toUserWithAnnotation(json);
        System.out.println(user);
    }
}