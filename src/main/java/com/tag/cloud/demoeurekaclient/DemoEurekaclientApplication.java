package com.tag.cloud.demoeurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaclientApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入服务客户端实例
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/cloud")
    public String gotoIndex() {
        return "spring cloud 1.0";
    }

    @RequestMapping("/rest-client")
    public String getClient() {
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client1");
        System.out.println(instances+" "+instances.get(0).getUri());
        System.out.println("http://" + instances.get(0).getServiceId() + "/cloud");
        String body = "";
        body = restTemplate.getForEntity("http://" + instances.get(0).getServiceId() + "/cloud", String.class).getBody();
        return body;
    }
}
