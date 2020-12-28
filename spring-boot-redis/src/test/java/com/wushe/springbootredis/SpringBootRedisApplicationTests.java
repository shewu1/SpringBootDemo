package com.wushe.springbootredis;

import com.wushe.springbootredis.model.UserInfo;
import com.wushe.springbootredis.util.RedisUtil;
import com.wushe.springbootredis.util.RedisUtilOld;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringBootRedisApplicationTests {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    //RedisUtilOld redisUtilOld;
    @Test
    void contextLoads() throws JSONException {
        UserInfo userInfo = new UserInfo(1, "jtb", 27);
        log.info("userInfo="+userInfo.toString());
        redisUtil.set("user:"+userInfo.getIdBgt(), userInfo);

        UserInfo user = (UserInfo) redisUtil.get("user:"+userInfo.getIdBgt());
        System.out.println("userr="+user.toString());
        /*JSONObject json = new JSONObject();
        json.put("jj", 19);
        json.put("kk", "kfd");
        redisUtil.set("bu2",json);
        System.out.println(redisUtil.get("bu"));*/
    }

    @Test
    void testRedis(){
        //UserInfo userInfo = new UserInfo(2, "jtb2", 27);

        //redisUtilOld.set("user:"+userInfo.getIdBgt(), userInfo);
    }

}
