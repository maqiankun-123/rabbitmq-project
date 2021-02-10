package com.springcloud.controller;

import com.springcloud.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * 马乾坤
 * 2021/2/3
 */
@RestController
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/getUserList")
    public String getUserList(){
        String url = "http://localhost:8081/getUserList";
        ResponseEntity<List> resout = restTemplate.getForEntity(url, List.class);
        System.out.println(resout.getStatusCode());//获取响应状态信息
        System.out.println(resout.getStatusCodeValue());//获取响应状态码
        System.out.println(resout.getHeaders());//获取响应头
        List body = resout.getBody();//获取响应体，服务提供者具体的响应数据
        for (Object o : body) {
            System.out.println(o.getClass());
        }
        return "第一个springcloud的消费者" + body;
    }
}
