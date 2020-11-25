package org.sy.jsr303demo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sy.jsr303demo.entity.TestEntity;
import org.sy.jsr303demo.valid.AddGroup;
import org.sy.jsr303demo.valid.UpdateGroup;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JSR303Controller {

    @RequestMapping("/save")
    public Map<String,Object> save(@Validated({AddGroup.class}) @RequestBody TestEntity testEntity) {

        //调用业务逻辑层
        System.out.println(testEntity);

        //放回结果
        Map<String,Object> result = new HashMap<>();
        result.put("code",200);
        result.put("msg","ok");
        result.put("data",new HashMap<String, String>());
        return result;
    }

    @RequestMapping("/update")
    public Map<String,Object> update(@Validated({UpdateGroup.class}) @RequestBody TestEntity testEntity) {

        //调用业务逻辑层
        System.out.println(testEntity);

        //放回结果
        Map<String,Object> result = new HashMap<>();
        result.put("code",200);
        result.put("msg","ok");
        result.put("data",new HashMap<String, String>());
        return result;
    }

}
