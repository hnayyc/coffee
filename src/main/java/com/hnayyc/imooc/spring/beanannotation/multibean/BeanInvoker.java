package com.hnayyc.imooc.spring.beanannotation.multibean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BeanInvoker {

    @Autowired
    @Qualifier("beanImplTwo")
    private BeanInterface beanInterface;

    @Autowired
    private List<BeanInterface> list;

    @Autowired
    private Map<String, BeanInterface> map;  // 注意：Map<K, V>的K必须是String类型，否则@Autowired不支持。

    public void say() {

        System.out.println("BeanInterface : " + this.beanInterface.getClass().getName() + "\n");

        if(null != this.list && 0 != list.size()) {
            System.out.println("list......");
            for(BeanInterface bean : list) {
                System.out.println(bean.getClass().getName());
            }
        }
        else {
            System.out.println("List<BeanInterface> list is null !!");
        }

        System.out.println();

        if(null != this.map && 0 != map.size()) {
            System.out.println("map......");
            for(Map.Entry<String, BeanInterface> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "  " + entry.getValue().getClass().getName());
            }
        }
        else {
            System.out.println("Map<String, BeanInterface> map is null !!");
        }
    }
}
