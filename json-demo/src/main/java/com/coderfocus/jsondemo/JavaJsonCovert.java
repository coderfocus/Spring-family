package com.coderfocus.jsondemo;

import java.io.*;

/**
* @Description: Java原生序列化
 * 优点：java原生支持，不需要提供第三方的类库，使用比较简单。
 * 缺点：无法跨语言，字节数占用比较大，某些情况下对于对象属性的变化比较敏感。
* @param:
* @return:
* @Author: songwenjie
* @Date: 2019/7/23
*/
public class JavaJsonCovert {

    public static void toJson(Object object) throws IOException {
        FileOutputStream out = new FileOutputStream("my.out");
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(object);
        oos.flush();
        oos.close();
        out.close();
        System.out.println(out.toString());
    }

    public static void toObject() throws IOException, ClassNotFoundException{
        FileInputStream in = new FileInputStream("my.out");
        ObjectInputStream oin = new ObjectInputStream(in);
        User user = (User) oin.readObject();
        oin.close();
        in.close();
        System.out.println(user);
    }
}
