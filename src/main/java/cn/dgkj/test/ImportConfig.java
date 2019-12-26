package cn.dgkj.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TestIOCBean.class, TestIOCBean2.class, MyImportSelector.class, SelfImportBeanDefinitionRegistrar.class})
@Configuration
public class ImportConfig {


}
