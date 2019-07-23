package com.coderfocus.jsondemo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConvert {

    /** 
    * @Description: 序列化 
    * @param: [obj]
    * @return: void 
    * @Author: songwenjie
    * @Date: 2019/7/23 
    */ 
    public static void toJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(obj);
        System.out.println(json);
    }

    /** 
    * @Description: 反序列化
    * @param: []
    * @return: com.coderfocus.jsondemo.User 
    * @Author: songwenjie
    * @Date: 2019/7/23 
    */ 
    public static User toUser(String json) throws IOException, JsonParseException, JsonMappingException {

        /**
         * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
         */
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        return user;
    }
}
