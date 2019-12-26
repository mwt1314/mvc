package cn.dgkj.service.impl;

import cn.dgkj.service.MyService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * @author mawt
 * @description
 * @date 2019/12/2
 */
@Service
@Scope(value = "MY_SERVICE", proxyMode = ScopedProxyMode.INTERFACES)
public class MyServiceImpl implements MyService {

    @Override
    public void run(String matio) {
        System.out.println(matio);
    }

}
