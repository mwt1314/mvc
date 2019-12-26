package cn.dgkj.cPropertySourceLoader;

import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.*;

/**
 * @author mawt
 * @description 自定义txt配置文件加载器
 * @date 2019/11/20
 */
public class CustomPropertySourceLoader implements PropertySourceLoader {

    private static final String TXT_FILE_EXTENSION = ".txt";

    @Override
    public String[] getFileExtensions() {
        return new String[]{"txt"};
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        List<PropertySource<?>> propertySources = new ArrayList<>();
        Map<String, Object> properties = new HashMap<String, Object>() {
            {
                put("name", "matio");
            }
        };
        propertySources.add(new OriginTrackedMapPropertySource(name, Collections.unmodifiableMap(properties), true));
        return propertySources;
    }

}
