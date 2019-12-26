package cn.dgkj.applistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author mawt
 */
public class CustomAppListener implements EnvironmentPostProcessor, ApplicationListener<CustomAppApplicationEvent>, Ordered {

    private static final int ORDER = 100;

    @Override
    public void onApplicationEvent(CustomAppApplicationEvent event) {

    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

    }

    @Override
    public int getOrder() {
        return ORDER;
    }

}
