package cn.dgkj;

import cn.dgkj.service.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author mawt
 * @description 测试  ParserStrategyUtils.invokeAwareMethods功能
 * @date 2019/11/26
 */
/*@Component*/
public class SpringBootInit implements EnvironmentAware, ResourceLoaderAware, BeanClassLoaderAware, BeanFactoryAware {

    /**
     * @see MyService
     *
     *
     */
    @Autowired
    private MyService myService;

    private Environment environment;

    private ResourceLoader resourceLoader;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    public SpringBootInit() {
        run();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void run() {
        myService.run("matio");
    }

}
