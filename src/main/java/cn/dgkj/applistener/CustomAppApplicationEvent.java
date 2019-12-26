package cn.dgkj.applistener;

import org.springframework.context.ApplicationEvent;

/**
 * @author mawt
 */
public class CustomAppApplicationEvent extends ApplicationEvent {

    public CustomAppApplicationEvent(Object source) {
        super(source);
    }

}
