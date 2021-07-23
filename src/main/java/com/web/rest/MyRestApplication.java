package com.web.rest;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
//網站有出現/rest後面全部都由rest控管

@ApplicationPath("/rest")
public class MyRestApplication extends Application {

    //註冊有哪些class是屬於rest的service
    @Override
    public Set<Class<?>> getClasses() {

        Set<Class<?>> classes = new LinkedHashSet();
        classes.add(HelloService.class);
        classes.add(BMIService.class);
        classes.add(BookService.class);
        return classes;
    }

}
