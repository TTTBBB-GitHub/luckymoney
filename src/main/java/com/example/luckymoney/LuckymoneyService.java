package com.example.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.net.proxy.PluginProxyInfo;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {
    @Autowired
    private LuckymoneyRepository repository;

    @Transactional //事务处理（如果其中一个执行出错，就会整个撤消事件），有些引擎不支持事务，可以切换引擎，比如inoDb
    public void createTwo(){
        Luckymoney luckymoney1=new Luckymoney();
        luckymoney1.setProducer("tangbo");
        luckymoney1.setMoney(new BigDecimal("520"));
        repository.save(luckymoney1);
        Luckymoney luckymoney2=new Luckymoney();
        luckymoney2.setProducer("tangbo");
        luckymoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckymoney2);

    }
}
