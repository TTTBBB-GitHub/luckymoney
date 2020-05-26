package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {
    //用来进行数据库的增删查
    @Autowired
    private LuckymoneyRepository repository;
//    用来进行服务
    @Autowired
    private LuckymoneyService service;
//    获取红包列表
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){

        return repository.findAll();
    }
//    创建红包，发红包
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money){
        Luckymoney luckymoney=new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }
//    通过ID查询红包
    @GetMapping("/luckymoney/{id}")
    public Luckymoney findById(@RequestParam("id") Integer id){
        return repository.findById(id).orElse(null);
    }
//    更新红包,领红包
    @PutMapping("/luckymoney/{id}")
    public Luckymoney update(@RequestParam("id") Integer id,
                             @RequestParam("consumer") String consumer){
//        先查询数据

        Optional<Luckymoney> optional=repository.findById(id);
        if(optional.isPresent()) {
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

//    发2个红包
    @PostMapping("/luckymoney/two")
    public void createTwo(){
        service.createTwo();
    }


}
