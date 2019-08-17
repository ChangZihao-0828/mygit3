package org.java;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmssystemApplicationTests {

    @Test
    public void contextLoads() {

        System.out.println("hello");
    }

    private final String pwd = "123456";
    @Test
    public void list() {
        Md5Hash md5 = new Md5Hash(pwd,"d102",5);
        System.out.println("加密后的结果是:"+md5.toString());
        //e9bf6ea1290f43204d9733664f2dc6a7
    }

}
