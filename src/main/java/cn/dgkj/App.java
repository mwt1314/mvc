package cn.dgkj;

import cn.dgkj.beannamegenerator.CustomBeanNameGenerator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;

/**
 * @author mawt
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, proxyMode = ScopedProxyMode.TARGET_CLASS)
@SpringBootApplication
@EnableScheduling
public class App implements EnvironmentAware {

    private Environment environment;

    public static void main(String[] args) {
        String x = "123";
        char c = x.charAt(2);
        Integer.parseInt(c + "");
        System.out.println(x.substring(1, 3));

        /**
         * 配置文件读取器PropertySourceLoader
         * 1.YamlPropertySourceLoader           负责读取yml和yaml后缀的文件
         * 2.PropertiesPropertySourceLoader     负责读取properties和xml后缀的文件
         * 3.自定义配置文件读取器
         *  3.1实现PropertySourceLoader接口
         *  3.2在META-INF/spring.factories中注册
         *      org.springframework.boot.env.PropertySourceLoader=cn.dgkj.cPropertySourceLoader.CustomPropertySourceLoader
         *
         * 自定义配置文件（默认目录限定为classpath:/,classpath:/config/,file:./,file:./config/，默认名称为application）
         * 假设额外的配置文件路径为classpath:/external/datasource.txt
         *
         *  1.run前
         *          //新增额外的配置文件（文件路径不是classpath:/,classpath:/config/,file:./,file:./config/时需要设置）
         *          System.setProperty(ConfigFileApplicationListener.CONFIG_ADDITIONAL_LOCATION_PROPERTY, "classpath:/external/");
         *          //新增的额外的配置文件的名称（文件名称不是application时需要设置）
         *          System.setProperty(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY, "application,datasource");
         *  2.如果文件后缀是（yml yaml properties xml）则不需要额外的操作，否则需要自定义配置文件读取器
         *      2.1实现PropertySourceLoader接口
         *      2.2在META-INF/spring.factories中注册（key为固定，value为自定义类的全路径）
         *          org.springframework.boot.env.PropertySourceLoader=cn.dgkj.cPropertySourceLoader.CustomPropertySourceLoader
         */

        /**
         * 自定义app的名称(配置文件中设置)
         * spring.application.name=BeanRootApp
         *
         */

        /**
         * @link cn.dgkj.initializer.CustomApplicationContextInitializer
         */
        System.setProperty("context.initializer.classes", "cn.dgkj.initializer.CustomApplicationContextInitializer");

        //新增额外的配置文件
        System.setProperty(ConfigFileApplicationListener.CONFIG_ADDITIONAL_LOCATION_PROPERTY, "classpath:/external/");
        //新增的额外的配置文件的名称
        System.setProperty(ConfigFileApplicationListener.CONFIG_NAME_PROPERTY, "application,datasource,mq");

        SpringApplication.run(App.class, args);
    //    run(args);
    }

    private void run(String[] args) {
        SpringApplication sc = new SpringApplication(null, new Class<?>[]{App.class});

        //自定义beanname生成规则
        sc.setBeanNameGenerator(new CustomBeanNameGenerator());


        Binder binder = Binder.get(environment);

        Map springMap = binder.bind("spring", Map.class).get();



        //添加命令行
        sc.setAddCommandLineProperties(true);
        //args不为空

        /*//禁止headless模式
        sc.setHeadless(false);


        sc.setBanner((environment, sourceClass, out) -> {


        });

        sc.setBannerMode(Banner.Mode.LOG);

        sc.getListeners().add(event -> {
            Object source = event.getSource();
            if (source instanceof SpringApplication) {

            }
        });*/

        AnnotationConfigServletWebServerApplicationContext cac = (AnnotationConfigServletWebServerApplicationContext)sc.run(args);
        ConfigurableListableBeanFactory beanFactory = cac.getBeanFactory();
        Iterator<String> it = beanFactory.getBeanNamesIterator();
        while(it.hasNext()) {
            String beanName = it.next();
            Object bean = beanFactory.getBean(beanName);
            System.out.println(bean.getClass().getName());
        }

        WebServer webServer = cac.getWebServer();

    }


    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
