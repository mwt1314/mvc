package cn.dgkj.initializer;

import cn.dgkj.config.SpringMVCConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.swing.*;

public class SpringMVCInitializer implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        //创建springmvc容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        //注册我们的配置文件
        context.register(SpringMVCConfig.class);

        //
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }

}
