package cn.dgkj.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class MyTomcat {

    public static void main(String[] args) throws ServletException, LifecycleException {
       /* Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);
        //读取项目路径
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File("src/main").getAbsolutePath());
        //禁止重新载入
        ctx.setReloadable(false);
        //class文件路径
        File targetFile = new File("target/classes");
        //创建webroot
        WebResourceRoot resources = new StandardRoot(ctx);
        //tomcat内部读取class执行
        resources.addPreResources(new DirResourceSet(resources, "/target/classes", targetFile.getAbsolutePath(), ""));
        tomcat.start();
        //异步等待请求执行
        tomcat.getServer().await();*/
    }

}
