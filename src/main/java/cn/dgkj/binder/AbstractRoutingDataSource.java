package cn.dgkj.binder;

/**
 * @author mawt
 * @description
 * @date 2019/11/25
 */
public abstract class AbstractRoutingDataSource {

    Object determineCurrentLookupKey() {
        return null;
    }

}
