package com.hnayyc.coffee.ioc.bean;

import com.hnayyc.coffee.ioc.annotation.IsAnnotation;
import com.hnayyc.coffee.ioc.annotation.SetterAnnotation;

@IsAnnotation
public class SetterBean {

    private IUser userdao;

    @SetterAnnotation(nation=EnglishUserImpl.class)
    public void setUserdao(IUser userdao) {
        this.userdao = userdao;
    }

    public void login_Test(){
        userdao.login();
    }
}
