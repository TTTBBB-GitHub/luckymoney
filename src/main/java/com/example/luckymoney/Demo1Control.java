package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//@RestController=@Controller + @ResponseBody
@RestController
@RequestMapping("/hello")
public class Demo1Control {
//    单个绑定配置中的值
//    @Value("${minMoney}")
//    private BigDecimal minMoney;
//    @Value("${description}")
//    private String description;

//    自动联系到配置类
    @Autowired
    private LimitConfig limitConfig;
//显示的页面的注解，URL注解
    @GetMapping("/say")
    public String say(){
        return "minMoney"+limitConfig.getDescription();
    }
    @GetMapping("/hello2")
//    @PostMapping("/hello2")
    public String say2(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "id "+myId;
    }

}
