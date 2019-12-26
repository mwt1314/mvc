package cn.dgkj.dubbo;

public class ProviderServiceImpl implements ProviderService {

    @Override
    public String SayHello(String word) {
        return word;
    }

}
