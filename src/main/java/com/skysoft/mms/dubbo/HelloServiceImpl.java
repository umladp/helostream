package com.skysoft.mms.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

// @Service为dubbo提供的Service注解，非Spring提供的  这个注记已经变更为 dubboservice了
//@Service 另外增加这个spring的服务注记，是不管用的：Spring的扫描不会把dubbo的这个服务类实例化到容器中，必须由dubbo自行反转和注入。
//@Service
@DubboService(interfaceClass = HelloService.class, version = "2.0.0")
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
