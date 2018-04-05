package com.hnayyc.imooc.spring.autowiring;

public class AutoWiringService {

    private AutoWiringDAO autoWiringDAO;

    // <beans defualt-autoware="byName">需要无参数的构造函数
    public AutoWiringService() {
        super();
    }

    public AutoWiringService(AutoWiringDAO autoWiringDAO) {
        System.out.println("AutoWiringService");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void setAutoWiringDAO(AutoWiringDAO autoWiringDAO) {
        System.out.println("setAutoWiringDAO");
        this.autoWiringDAO = autoWiringDAO;
    }

    public void say(String word) {
        this.autoWiringDAO.say(word);
    }
}
