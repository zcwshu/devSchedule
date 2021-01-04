package com.atguigu.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:11 2020/12/17
 */

//当项目一启动,spring接口,spring加载后,执行接口一个方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容 spring中value注解属性注入注解
    @Value("oss-cn-beijing.aliyuncs.com")
    private String endpoint;

    @Value("LTAI4G4SswUVQrwQWf1iAPkV")
    private String keyId;

    @Value("OlFIx1j2OaIJ4DYvb9c60QL05fopAF")
    private String keySecret;

    @Value("edu-a1010")
    private String bucketName;


    //定义公共静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}
